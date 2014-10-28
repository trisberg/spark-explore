/* Hashtags.scala */
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import scala.util.parsing.json._

object Hashtags {
  def main(args: Array[String]) {
    val tweetFile = args(0)

    val conf = new SparkConf().setAppName("Hashtags")
    val sc = new SparkContext(conf)

    val tweetdata = sc.textFile(tweetFile)
    val tweets = tweetdata.map(line => JSON.parseFull(line).get.asInstanceOf[Map[String, Any]])

    val hashTags = tweets.flatMap(map => map.get("text").toString().split(" ").filter(_.startsWith("#")))
    val hashTagsCounts = hashTags.map((_, 1)).reduceByKey((a, b) => a + b)
    val top10 = hashTagsCounts.map{case (t, c) => (c, t)}.sortByKey(false).map{case (c, t) => (t, c)}.take(10)

    println("Top 10 hashtags:")
    top10.foreach(println)
    sc.stop()
  }
}
