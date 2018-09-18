package com.dashlane.benchmarks.json

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_test.*
import java.io.File
import java.util.*
import kotlin.properties.Delegates

/**
 * Activity used to run tests and display the result.
 */
class TestActivity : AppCompatActivity() {

    private var task by Delegates.observable<TestTask?>(null) { _, oldValue, _ ->
        oldValue?.cancel(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val logBuilder = StringBuilder()
        Log.printers.add {
            runOnUiThread {
                logBuilder.appendln(it)
                view_text.text = logBuilder
            }
        }

        Log.level = intent.getStringExtra(EXTRA_LOG_LEVEL)?.let { enumValueOf<Log.Level>(it) }
                ?: Log.Level.INFO

        val repeat = intent.getIntExtra(EXTRA_REPETITIONS, DEFAULT_REPEAT)
        view_test_progress.max = repeat
        val tests: TestIntent = intent.getParcelableExtra(EXTRA_TESTS) ?: return
        val testDir = File(cacheDir, UUID.randomUUID().toString())
        val testList = tests.toTestPlan().toList()
        task = TestTask(testDir, repeat).apply {
            onProgress = {
                view_test_title.text = "Running test ${it.first}/${testList.size}"
                view_test_progress.progress = it.second
            }
            execute(*testList.toTypedArray())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        task = null
    }

    companion object {
        /**
         * Default number of times each test is repeated, if no extra with key [EXTRA_REPETITIONS]
         * is provided.
         */
        const val DEFAULT_REPEAT = 100

        /** Intent extra with the name of a [Log.Level] enum value indicating the verbosity. */
        const val EXTRA_LOG_LEVEL = "log"
        /** Intent extra with the number of times to repeat each test. */
        const val EXTRA_REPETITIONS = "repeat"
        /** Required intent extra with a specification of the tests to run. */
        const val EXTRA_TESTS = "tests"
    }
}

