package com.scalainaction.mongo

import com.mongodb.Mongo

class MongoClient(val host: String, val port: Int) {
  require(host != null, "Your have to provide a host name")
  private val underlying = new Mongo(host, port)

  def this() = this("127.0.0.1", 27017)
}
