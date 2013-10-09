package org.ffmmx.androidscala

import android.app._
import android.view._
import scala.collection.mutable._
import android.content._
import scala.reflect._
import android.os._
import android.widget._
import android.telephony.SmsManager

class RichActivity(activity: Activity) {
  def get[T <: View](id: Int): T = {
    activity.findViewById(id).asInstanceOf[T]
  }
}

trait Creatable {
  protected val onCreateBodies = new ArrayBuffer[() => Any]
  def onCreate(body: => Any) = {
    val el = (() => body)
    onCreateBodies += el
    el
  }
}

trait Destroyable {
  protected val onDestroyBodies = new ArrayBuffer[() => Any]
  def onDestroy(body: => Any) = {
    val el = (() => body)
    onDestroyBodies += el
    el
  }
}

trait Registerable {
  def onRegister(body: => Any): () => Any
  def onUnregister(body: => Any): () => Any
}

trait TraitActivity[V <: Activity] {
  @inline def contentView_=(p: View) = {
    basis.setContentView(p)
    basis
  }

  @inline def contentView(p: View) = contentView_=(p)

  @inline def contentView(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'contentView'")

  def contentView_=(i: Int) = {
    basis.setContentView(i)
    basis
  }
  def contentView(layoutId: Int) = contentView_=(layoutId)

  def basis: Activity

  def find[V <: View](id: Int): V = basis.findViewById(id).asInstanceOf[V]
}
trait SActivity extends Activity
  with RContext
  with TraitActivity[SActivity]
  with Creatable
  with Destroyable
  with Registerable {

  override def basis = this

  override implicit val ctx = basis

  def onRegister(body: => Any) = onResume(body)

  def onUnregister(body: => Any) = onPause(body)

  val onStartStop = new Registerable {
    def onRegister(body: => Any) = onStart(body)
    def onUnregister(body: => Any) = onStop(body)
  }
  override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    onCreateBodies.foreach(_())
  }

  override def onDestroy() {
    onDestroyBodies.foreach(_())
    super.onDestroy()
  }

  override def onStart {
    super.onStart()
    onStartBodies.foreach(_())
  }

  protected val onStartBodies = new ArrayBuffer[() => Any]

  def onStart(body: => Any) = {
    val el = (() => body)
    onStartBodies += el
    el
  }

  override def onResume {
    super.onResume()
    onResumeBodies.foreach(_())
  }

  protected val onResumeBodies = new ArrayBuffer[() => Any]

  def onResume(body: => Any) = {
    val el = (() => body)
    onResumeBodies += el
    el
  }

  override def onPause {
    onPauseBodies.foreach(_())
    super.onPause()
  }

  protected val onPauseBodies = new ArrayBuffer[() => Any]

  def onPause(body: => Any) = {
    val el = (() => body)
    onPauseBodies += el
    el
  }

  protected val onStopBodies = new ArrayBuffer[() => Any]
  def onStop(body: => Any) = {
    val el = (() => body)
    onStopBodies += el
    el
  }

  override def onStop() {
    onStopBodies.foreach(_())
    super.onStop()
  }

}

trait TraitContext[T <: Context] {
  def basis: T

  implicit val ctx = basis

  @inline def applicationContext = basis.getApplicationContext

  @inline def applicationInfo = basis.getApplicationInfo

  @inline def assets = basis.getAssets

  @inline def cacheDir = basis.getCacheDir

  @inline def classLoader = basis.getClassLoader

  @inline def contentResolver = basis.getContentResolver

  @inline def externalCacheDir = basis.getExternalCacheDir

  @inline def filesDir = basis.getFilesDir

  @inline def mainLooper = basis.getMainLooper

  @inline def packageCodePath = basis.getPackageCodePath

  @inline def packageManager = basis.getPackageManager

  @inline def packageName = basis.getPackageName

  @inline def packageResourcePath = basis.getPackageResourcePath

  @inline def resources = basis.getResources

  @inline def theme = basis.getTheme
  @inline def theme(p: Int) = theme_=(p)
  @inline def theme_=(p: Int) = { basis.setTheme(p); basis }

  @inline def wallpaper = basis.getWallpaper
  @inline def wallpaper(p: android.graphics.Bitmap) = wallpaper_=(p)
  @inline def wallpaper_=(p: android.graphics.Bitmap) = { basis.setWallpaper(p); basis }
  @inline def wallpaper(p: java.io.InputStream) = wallpaper_=(p)
  @inline def wallpaper_=(p: java.io.InputStream) = { basis.setWallpaper(p); basis }

  @inline def wallpaperDesiredMinimumHeight = basis.getWallpaperDesiredMinimumHeight

  @inline def wallpaperDesiredMinimumWidth = basis.getWallpaperDesiredMinimumWidth

  @inline def bindService[T: ClassTag](p1: android.content.ServiceConnection, p2: Int)(implicit context: Context): Boolean = basis.bindService(RIntent[T], p1, p2)

  @inline def removeStickyBroadcast[T: ClassTag](implicit context: Context): Unit = basis.removeStickyBroadcast(RIntent[T])

  @inline def sendBroadcast[T: ClassTag](implicit context: Context): Unit = basis.sendBroadcast(RIntent[T])

  @inline def sendBroadcast[T: ClassTag](p: java.lang.String)(implicit context: Context): Unit = basis.sendBroadcast(RIntent[T], p)

  @inline def sendOrderedBroadcast[T: ClassTag](p: java.lang.String)(implicit context: Context): Unit = basis.sendOrderedBroadcast(RIntent[T], p)

  @inline def sendOrderedBroadcast[T: ClassTag](p1: java.lang.String, p2: android.content.BroadcastReceiver, p3: android.os.Handler, p4: Int, p5: java.lang.String, p6: android.os.Bundle)(implicit context: Context): Unit = basis.sendOrderedBroadcast(RIntent[T], p1, p2, p3, p4, p5, p6)

  @inline def sendStickyBroadcast[T: ClassTag](implicit context: Context): Unit = basis.sendStickyBroadcast(RIntent[T])

  @inline def sendStickyOrderedBroadcast[T: ClassTag](p1: android.content.BroadcastReceiver, p2: android.os.Handler, p3: Int, p4: java.lang.String, p5: android.os.Bundle)(implicit context: Context): Unit = basis.sendStickyOrderedBroadcast(RIntent[T], p1, p2, p3, p4, p5)

  @inline def startActivity[T: ClassTag](implicit context: Context): Unit = basis.startActivity(RIntent[T])

  @inline def startService[T: ClassTag](implicit context: Context): android.content.ComponentName = basis.startService(RIntent[T])

  @inline def stopService[T: ClassTag](implicit context: Context): Boolean = basis.stopService(RIntent[T])
}

object RIntent {
  @inline def apply[T](implicit context: Context, mt: ClassTag[T]) = new Intent(context, mt.runtimeClass)

  @inline def apply[T](action: String)(implicit context: Context, mt: ClassTag[T]): Intent = RIntent[T].setAction(action)
}

trait RContext extends Context with TraitContext[RContext] {
  def basis = this
}

trait RService extends Service with RContext
  with Creatable
  with Destroyable
  with Registerable {

  override def onCreate() {
    super.onCreate()

    onCreateBodies.foreach(_())
  }

  override def onDestroy() {
    onDestroyBodies.foreach(_())
    super.onDestroy()
  }

  def onRegister(body: => Any) = onCreate(body)
  def onUnregister(body: => Any) = onDestroy(body)
}

/**
 * A Scala-style builder for AlertDialog.
 * {{{
 *  new AlertDialogBuilder("Exit the app", "Do you really want to exit?") {
 *    positiveButton("Exit", finishTheApplication())
 *    negativeButton("Cancel")
 *  }.show()
 * }}}
 * This displays an alert dialog with given string resources.
 *
 * Although this builder displays some UI element, this builder can be called from any thread, because the method `show()` handles threading internally.
 *
 * Please refer to the URL below for more details.
 *
 * [[https://github.com/pocorall/scaloid/wiki/Basics#class-alertdialogbuilder]]
 *
 * See also: `alert()`
 */
class AlertDialogBuilder(_title: CharSequence = null, _message: CharSequence = null)(implicit context: Context) extends AlertDialog.Builder(context) {
  if (_title != null) setTitle(_title)
  if (_message != null) setMessage(_message)

  @inline def positiveButton(name: CharSequence = android.R.string.yes, onClick: => Unit = {}): AlertDialogBuilder =
    positiveButton(name, (_, _) => {
      onClick
    })

  @inline def positiveButton(name: CharSequence, onClick: (DialogInterface, Int) => Unit): AlertDialogBuilder = {
    setPositiveButton(name, func2DialogOnClickListener(onClick))
    this
  }

  @inline def neutralButton(name: CharSequence = android.R.string.ok, onClick: => Unit = {}): AlertDialogBuilder =
    neutralButton(name, (_, _) => {
      onClick
    })

  @inline def neutralButton(name: CharSequence, onClick: (DialogInterface, Int) => Unit): AlertDialogBuilder = {
    setNeutralButton(name, func2DialogOnClickListener(onClick))
    this
  }

  @inline def negativeButton(name: CharSequence, onClick: => Unit): AlertDialogBuilder =
    negativeButton(name, (_, _) => {
      onClick
    })

  @inline def negativeButton(name: CharSequence = android.R.string.no, onClick: (DialogInterface, Int) => Unit = (d, _) => {
    d.cancel()
  }): AlertDialogBuilder = {
    setNegativeButton(name, func2DialogOnClickListener(onClick))
    this
  }

  var tit: CharSequence = null

  @inline def title_=(str: CharSequence) = {
    tit = str
    setTitle(str)
  }

  @inline def title = tit

  var msg: CharSequence = null

  @inline def message_=(str: CharSequence) = {
    msg = str
    setMessage(str)
  }

  @inline def message = msg

  /**
   * Shows the dialog that is currently building.
   * Because this method runs runOnUiThread internally, you can call this method from any thread.
   */
  override def show(): AlertDialog = runOnUiThread(super.show())
}

trait TraitSmsManager[V <: SmsManager] {
  val SMS_URI = "content://sms"
  val SMS_URI_INBOX = "content://sms/inbox"
  val SMS_URI_SENT = "content://sms/sent"
  val SMS_URI_DRAFT = "content://sms/draft"
  val SMS_URI_OUTBOX = "content://sms/outbox"
  val SMS_URI_FAILED = "content://sms/failed"
  val SMS_URI_QUEUED = "content://sms/queued"

  val MESSAGE_TYPE_ALL = 0
  val MESSAGE_TYPE_INBOX = 1
  val MESSAGE_TYPE_SENT = 2
  val MESSAGE_TYPE_DRAFT = 3
  val MESSAGE_TYPE_OUTBOX = 4
  val MESSAGE_TYPE_FAILED = 5 // for failed outgoing messages  
  val MESSAGE_TYPE_QUEUED = 6 // for messages to send later  

  val MESSAGE_READ_TYPE_UNREAD = 0
  val MESSAGE_READ_TYPE_READED = 1

  val SMS_THREAD_ID = "thread_id"
  val SMS_ADDRESS = "address"
  val SMS_PERSON = "person"
  val SMS_DATE = "date"
  val SMS_PROTOCOL = "protocol"
  val SMS_READ = "read"
  val SMS_STATUS = "status"
  val SMS_TYPE = "type"
  val SMS_REPLY_PATH_PRESENT = "reply_path_present"
  val SMS_SUBJECT = "subject"
  val SMS_BODY = "body"
  val SMS_SERVICE_CENTER = "service_center"
  val SMS_LOCKED = "locked"
    
  val SMS_STATUS_NONE = -1
  val SMS_STATUS_COMPLETE = 0
  val SMS_STATUS_PENDING = 64
  val SMS_STATUS_FAILD = 128
  def basis: V

  def getDefault() = SmsManager.getDefault()

}

object SSmsManager extends TraitSmsManager[SmsManager] {
  def basis = getDefault

}