# setwd("~/Downloads")
#results = read.csv2("results_galaxy_s8_api_24.csv", sep = ",")
results = read.csv2("results_nexus_6_api_23.csv", sep = ",")
results$JSON.Size <- NULL
results$Write.JSON.to.File <- NULL

data <- data.frame("Test" = c(), "Duration" = c(), "Name" = c())
for (i in 2:4) {
  test_data <- results[,c(1,i)]
  test_data[,3] <- rep(colnames(results)[i], length(test_data))
  colnames(test_data) <- c("Test", "Duration", "Name")
  data = rbind(data, test_data)
}
data$Duration <- as.numeric(lapply(data$Duration, sub, pattern = "ms", replacement = ""))
data$Test <- factor(data$Test)

# install.packages("ggplot2")
library(ggplot2)

ggplot(data, aes(x = Test, y = Duration, fill = Name)) + 
  geom_bar(stat = "identity", position=position_dodge()) + 
  labs(y = "Duration (ms)", fill = "Library")

