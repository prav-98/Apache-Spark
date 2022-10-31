import org.apache.spark.sql.SparkSession
object SparkApplication extends App {
  val spark = SparkSession.builder()
      .master("local[1]")
      .appName("SparkByExamples.com")
      .getOrCreate();

    
      val df=spark.spark.read
          .option("delimiter", ",")
          .option("header", true)
          .csv()

    }