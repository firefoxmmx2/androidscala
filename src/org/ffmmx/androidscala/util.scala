package org.ffmmx.androidscala

import org.apache.http.client.methods._
import scala.collection.immutable._
import org.apache.http.message._
import org.apache.http.client.entity._
import scala.collection.JavaConverters._
import org.apache.http.client._
import org.apache.http.impl.client._
import org.apache.http._
import android.content.Context
import android.widget.Toast

object Utils {
  def doHttpRequest(url: String,
                    data: Map[String, String] = null,
                    async: Boolean = false,
                    onSuccess: (HttpResponse, HttpClient) => Unit = null,
                    onFailture: (HttpResponse, Int, HttpClient) => Unit = null,
                    encoding: String = "utf8"): Unit = {
    val req = if (data == null || data.isEmpty) new HttpGet(url)
    else new HttpPost(url)
    val params = for ((k, v) <- data) yield new BasicNameValuePair(k, v)

    def callFunc: Unit = {
      req match {
        case t: HttpPost => {
          t.setEntity(new UrlEncodedFormEntity(params.toList.asJava, encoding))
        }
      }

      val client = new DefaultHttpClient
      val resp = client.execute(req)
      if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
        if (onSuccess != null) {
          onSuccess(resp, client)
        }
      } else {
        if (onFailture != null) {
          onFailture(resp, resp.getStatusLine().getStatusCode(), client)
        }
      }
    }
    if (async == false) {
      callFunc
    } else {

    }
  }

  def toast(content: String, flag: Int)(implicit context: Context) {
    Toast.makeText(context, content, flag).show()
  }

  def toastShort(content: String)(implicit context: Context) {
    toast(content, Toast.LENGTH_SHORT)
  }

  def toastLong(content: String)(implicit context: Context) {
    toast(content, Toast.LENGTH_LONG)
  }
}