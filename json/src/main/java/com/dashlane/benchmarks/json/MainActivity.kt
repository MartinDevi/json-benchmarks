package com.dashlane.benchmarks.json

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dashlane.benchmarks.json.test1.Test1
import com.dashlane.benchmarks.json.test2.Test2
import com.dashlane.benchmarks.json.test3.Test3
import com.dashlane.benchmarks.json.test4.Test4
import com.dashlane.benchmarks.json.test5.Test5
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Activity used to specify which tests to run.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateTestNames()

        view_debug_level.setOnSeekBarProgressChangeListener { progress ->
            view_debug_level_text.text = ordinalName<Log.Level>(progress)
        }

        view_run_tests.setOnClickListener {
            val repetitions = try {
                view_repetitions.text.toString().toInt()
            } catch (e: NumberFormatException) {
                view_repetitions.error = "Invalid value"
                return@setOnClickListener
            }
            val testIntent = TestIntent(
                    view_test1_1.isChecked,
                    view_test1_2.isChecked,
                    view_test2.isChecked,
                    view_test3.isChecked,
                    view_test4.isChecked,
                    view_test5.isChecked
            )
            startActivity<TestActivity> {
                putExtra(TestActivity.EXTRA_LOG_LEVEL, ordinalName<Log.Level>(view_debug_level.progress))
                putExtra(TestActivity.EXTRA_REPETITIONS, repetitions)
                putExtra(TestActivity.EXTRA_TESTS, testIntent)
            }
        }
    }

    private fun updateTestNames() {
        view_test1_1.text = Test1.Small.testName
        view_test1_2.text = Test1.Large.testName
        view_test2.text = Test2.testName
        view_test3.text = Test3.testName
        view_test4.text = Test4.testName
        view_test5.text = Test5.testName
    }
}
