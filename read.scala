import org.apache.spark.sql.SparkSession
object SparkApplication extends App {
  val spark = SparkSession.builder()
      .master("local[1]")
      .appName("SparkByExamples.com")
      .getOrCreate();

    
      val df=spark.read
          .option("delimiter", ",")
          .option("header", true)
          .csv("/Users/ayomalpraveen/Desktop/Apache-Spark-Code/Samples/first.csv")

        val anotherDf=spark.read
          .option("delimiter", ",")
          .option("header", true)
          .csv("/Users/ayomalpraveen/Desktop/Apache-Spark-Code/Samples/second.csv")


        //filtering the males
        val maledf=df.filter($"SEX" === "M").show(10)

        //filtering people who are females & whose age are greater than 40
        val femaleOlderDf=df.filter(df("Sex") === "F" && df("Age") > 40)

        //filtering tall males
        val tallMalesDf=df.filter(df("Sex")==="M" && df("Height (in)") > "65")

        //calculating overweight
        val overweight=df.withColumn("isOverweight",
            when(col("Weight (lbs)")>70,"Overweight")
            .when(col("Weight (lbs)")>50 && "Weight (lbs)"<70,"Normal Weight")
            .otherwise("Lightweight"))

        df.join(anotherDf,Seq("Name"),"inner")

        df.join(anotherDf,Seq("Name"),"full outer")

        
        overweight
        .write
        .mode(SaveMode.Overwrite)
        .option("header", true)
        .csv("/Users/ayomalpraveen/Desktop/Apache-Spark-Code/output")

    }