package org.ffmmx.androidscala

import android.app._
import android.view._
import android.widget._
import scala.collection.mutable.ArrayBuffer

trait TraitButton[T <: Button] extends TraitView[T] {

}

class RichButton(button: Button) extends TraitButton[Button] {
  def basis = button
}

trait TraitView[V <: View] extends ConstantsSupport {
  def basis: V

  def find[V <: View](id: Int): V = basis.findViewById(id).asInstanceOf[V]

  def uniqueId(implicit activity: Activity): Int = {
    if (basis.getId < 0) {
      basis.setId(getUniqueId)
    }
    basis.getId
  }

  val FILL_PARENT = ViewGroup.LayoutParams.FILL_PARENT
  val MATCH_PARENT = ViewGroup.LayoutParams.MATCH_PARENT
  val WRAP_CONTENT = ViewGroup.LayoutParams.WRAP_CONTENT

  def <<[LP <: ViewGroupLayoutParams[_, _]](implicit defaultLayoutParam: (V) => LP): LP =
    defaultLayoutParam(basis)

  protected def parentViewGroupIfExists[LP <: ViewGroupLayoutParams[_, _]](implicit defaultLayoutParam: (V) => LP = (v: V) => null): TraitViewGroup[_] = {
    val lp = defaultLayoutParam(basis)
    if (lp == null) null else lp.parent
  }

  def <<[LP <: ViewGroupLayoutParams[_, _]](width: Int, height: Int)(implicit defaultLayoutParam: (V) => LP): LP = {
    val lp = defaultLayoutParam(basis)
    lp.height = height
    lp.width = width
    lp
  }

  val parentViewGroup: TraitViewGroup[_] = null

  @inline def padding_=(p: Int) = {
    basis.setPadding(p, p, p, p)
    basis
  }

  @inline def padding(p: Int) = padding_=(p)

  @inline def padding: Int = 0

  @inline def padding(p1: Int, p2: Int, p3: Int, p4: Int) = {
    basis.setPadding(p1, p2, p3, p4)
    basis
  }

  @inline def animation = basis.getAnimation
  @inline def animation(p: android.view.animation.Animation) = animation_=(p)
  @inline def animation_=(p: android.view.animation.Animation) = { basis.setAnimation(p); basis }

  @inline def applicationWindowToken = basis.getApplicationWindowToken

  @inline def background = basis.getBackground

  @inline def backgroundColor(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'backgroundColor'")
  @inline def backgroundColor(p: Int) = backgroundColor_=(p)
  @inline def backgroundColor_=(p: Int) = { basis.setBackgroundColor(p); basis }

  @inline def backgroundDrawable(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'backgroundDrawable'")
  @inline def backgroundDrawable(p: android.graphics.drawable.Drawable) = backgroundDrawable_=(p)
  @inline def backgroundDrawable_=(p: android.graphics.drawable.Drawable) = { basis.setBackgroundDrawable(p); basis }

  @inline def backgroundResource(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'backgroundResource'")
  @inline def backgroundResource(p: Int) = backgroundResource_=(p)
  @inline def backgroundResource_=(p: Int) = { basis.setBackgroundResource(p); basis }

  @inline def baseline = basis.getBaseline

  @inline def bottom = basis.getBottom

  @inline def clickable = basis.isClickable
  @inline def clickable(p: Boolean) = clickable_=(p)
  @inline def clickable_=(p: Boolean) = { basis.setClickable(p); basis }

  @inline def contentDescription = basis.getContentDescription
  @inline def contentDescription(p: java.lang.CharSequence) = contentDescription_=(p)
  @inline def contentDescription_=(p: java.lang.CharSequence) = { basis.setContentDescription(p); basis }

  @inline def context = basis.getContext

  @inline def drawableState = basis.getDrawableState

  @inline def drawingCache = basis.getDrawingCache

  @inline def drawingCacheBackgroundColor = basis.getDrawingCacheBackgroundColor
  @inline def drawingCacheBackgroundColor(p: Int) = drawingCacheBackgroundColor_=(p)
  @inline def drawingCacheBackgroundColor_=(p: Int) = { basis.setDrawingCacheBackgroundColor(p); basis }

  @inline def drawingCacheEnabled = basis.isDrawingCacheEnabled
  @inline def drawingCacheEnabled(p: Boolean) = drawingCacheEnabled_=(p)
  @inline def drawingCacheEnabled_=(p: Boolean) = { basis.setDrawingCacheEnabled(p); basis }
  @inline def enableDrawingCache = { basis.setDrawingCacheEnabled(true); basis }
  @inline def disableDrawingCache = { basis.setDrawingCacheEnabled(false); basis }

  @inline def drawingCacheQuality = basis.getDrawingCacheQuality
  @inline def drawingCacheQuality(p: Int) = drawingCacheQuality_=(p)
  @inline def drawingCacheQuality_=(p: Int) = { basis.setDrawingCacheQuality(p); basis }

  @inline def drawingTime = basis.getDrawingTime

  @inline def duplicateParentStateEnabled = basis.isDuplicateParentStateEnabled
  @inline def duplicateParentStateEnabled(p: Boolean) = duplicateParentStateEnabled_=(p)
  @inline def duplicateParentStateEnabled_=(p: Boolean) = { basis.setDuplicateParentStateEnabled(p); basis }
  @inline def enableDuplicateParentState = { basis.setDuplicateParentStateEnabled(true); basis }
  @inline def disableDuplicateParentState = { basis.setDuplicateParentStateEnabled(false); basis }

  @inline def enabled = basis.isEnabled
  @inline def enabled(p: Boolean) = enabled_=(p)
  @inline def enabled_=(p: Boolean) = { basis.setEnabled(p); basis }
  @inline def enable = { basis.setEnabled(true); basis }
  @inline def disable = { basis.setEnabled(false); basis }

  @inline def fadingEdgeLength(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'fadingEdgeLength'")
  @inline def fadingEdgeLength(p: Int) = fadingEdgeLength_=(p)
  @inline def fadingEdgeLength_=(p: Int) = { basis.setFadingEdgeLength(p); basis }

  @inline def focusable = basis.isFocusable
  @inline def focusable(p: Boolean) = focusable_=(p)
  @inline def focusable_=(p: Boolean) = { basis.setFocusable(p); basis }

  @inline def focusableInTouchMode = basis.isFocusableInTouchMode
  @inline def focusableInTouchMode(p: Boolean) = focusableInTouchMode_=(p)
  @inline def focusableInTouchMode_=(p: Boolean) = { basis.setFocusableInTouchMode(p); basis }

  @inline def handler = basis.getHandler

  @inline def hapticFeedbackEnabled = basis.isHapticFeedbackEnabled
  @inline def hapticFeedbackEnabled(p: Boolean) = hapticFeedbackEnabled_=(p)
  @inline def hapticFeedbackEnabled_=(p: Boolean) = { basis.setHapticFeedbackEnabled(p); basis }
  @inline def enableHapticFeedback = { basis.setHapticFeedbackEnabled(true); basis }
  @inline def disableHapticFeedback = { basis.setHapticFeedbackEnabled(false); basis }

  @inline def height = basis.getHeight

  @inline def horizontalFadingEdgeEnabled = basis.isHorizontalFadingEdgeEnabled
  @inline def horizontalFadingEdgeEnabled(p: Boolean) = horizontalFadingEdgeEnabled_=(p)
  @inline def horizontalFadingEdgeEnabled_=(p: Boolean) = { basis.setHorizontalFadingEdgeEnabled(p); basis }
  @inline def enableHorizontalFadingEdge = { basis.setHorizontalFadingEdgeEnabled(true); basis }
  @inline def disableHorizontalFadingEdge = { basis.setHorizontalFadingEdgeEnabled(false); basis }

  @inline def horizontalFadingEdgeLength = basis.getHorizontalFadingEdgeLength

  @inline def horizontalScrollBarEnabled = basis.isHorizontalScrollBarEnabled
  @inline def horizontalScrollBarEnabled(p: Boolean) = horizontalScrollBarEnabled_=(p)
  @inline def horizontalScrollBarEnabled_=(p: Boolean) = { basis.setHorizontalScrollBarEnabled(p); basis }
  @inline def enableHorizontalScrollBar = { basis.setHorizontalScrollBarEnabled(true); basis }
  @inline def disableHorizontalScrollBar = { basis.setHorizontalScrollBarEnabled(false); basis }

  @inline def id = basis.getId
  @inline def id(p: Int) = id_=(p)
  @inline def id_=(p: Int) = { basis.setId(p); basis }

  @inline def keepScreenOn = basis.getKeepScreenOn
  @inline def keepScreenOn(p: Boolean) = keepScreenOn_=(p)
  @inline def keepScreenOn_=(p: Boolean) = { basis.setKeepScreenOn(p); basis }

  @inline def keyDispatcherState = basis.getKeyDispatcherState

  @inline def layoutParams = basis.getLayoutParams
  @inline def layoutParams(p: android.view.ViewGroup.LayoutParams) = layoutParams_=(p)
  @inline def layoutParams_=(p: android.view.ViewGroup.LayoutParams) = { basis.setLayoutParams(p); basis }

  @inline def left = basis.getLeft

  @inline def longClickable = basis.isLongClickable
  @inline def longClickable(p: Boolean) = longClickable_=(p)
  @inline def longClickable_=(p: Boolean) = { basis.setLongClickable(p); basis }

  @inline def measuredHeight = basis.getMeasuredHeight

  @inline def measuredWidth = basis.getMeasuredWidth

  @inline def minimumHeight(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'minimumHeight'")
  @inline def minimumHeight(p: Int) = minimumHeight_=(p)
  @inline def minimumHeight_=(p: Int) = { basis.setMinimumHeight(p); basis }

  @inline def minimumWidth(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'minimumWidth'")
  @inline def minimumWidth(p: Int) = minimumWidth_=(p)
  @inline def minimumWidth_=(p: Int) = { basis.setMinimumWidth(p); basis }

  @inline def nextFocusDownId = basis.getNextFocusDownId
  @inline def nextFocusDownId(p: Int) = nextFocusDownId_=(p)
  @inline def nextFocusDownId_=(p: Int) = { basis.setNextFocusDownId(p); basis }

  @inline def nextFocusLeftId = basis.getNextFocusLeftId
  @inline def nextFocusLeftId(p: Int) = nextFocusLeftId_=(p)
  @inline def nextFocusLeftId_=(p: Int) = { basis.setNextFocusLeftId(p); basis }

  @inline def nextFocusRightId = basis.getNextFocusRightId
  @inline def nextFocusRightId(p: Int) = nextFocusRightId_=(p)
  @inline def nextFocusRightId_=(p: Int) = { basis.setNextFocusRightId(p); basis }

  @inline def nextFocusUpId = basis.getNextFocusUpId
  @inline def nextFocusUpId(p: Int) = nextFocusUpId_=(p)
  @inline def nextFocusUpId_=(p: Int) = { basis.setNextFocusUpId(p); basis }

  @inline def onClickListener(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'onClickListener'")
  @inline def onClickListener(p: android.view.View.OnClickListener) = onClickListener_=(p)
  @inline def onClickListener_=(p: android.view.View.OnClickListener) = { basis.setOnClickListener(p); basis }

  @inline def onCreateContextMenuListener(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'onCreateContextMenuListener'")
  @inline def onCreateContextMenuListener(p: android.view.View.OnCreateContextMenuListener) = onCreateContextMenuListener_=(p)
  @inline def onCreateContextMenuListener_=(p: android.view.View.OnCreateContextMenuListener) = { basis.setOnCreateContextMenuListener(p); basis }

  @inline def onFocusChangeListener = basis.getOnFocusChangeListener
  @inline def onFocusChangeListener(p: android.view.View.OnFocusChangeListener) = onFocusChangeListener_=(p)
  @inline def onFocusChangeListener_=(p: android.view.View.OnFocusChangeListener) = { basis.setOnFocusChangeListener(p); basis }

  @inline def onKeyListener(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'onKeyListener'")
  @inline def onKeyListener(p: android.view.View.OnKeyListener) = onKeyListener_=(p)
  @inline def onKeyListener_=(p: android.view.View.OnKeyListener) = { basis.setOnKeyListener(p); basis }

  @inline def onLongClickListener(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'onLongClickListener'")
  @inline def onLongClickListener(p: android.view.View.OnLongClickListener) = onLongClickListener_=(p)
  @inline def onLongClickListener_=(p: android.view.View.OnLongClickListener) = { basis.setOnLongClickListener(p); basis }

  @inline def onTouchListener(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'onTouchListener'")
  @inline def onTouchListener(p: android.view.View.OnTouchListener) = onTouchListener_=(p)
  @inline def onTouchListener_=(p: android.view.View.OnTouchListener) = { basis.setOnTouchListener(p); basis }

  @inline def paddingBottom = basis.getPaddingBottom

  @inline def paddingLeft = basis.getPaddingLeft

  @inline def paddingRight = basis.getPaddingRight

  @inline def paddingTop = basis.getPaddingTop

  @inline def parent = basis.getParent

  @inline def pressed = basis.isPressed
  @inline def pressed(p: Boolean) = pressed_=(p)
  @inline def pressed_=(p: Boolean) = { basis.setPressed(p); basis }

  @inline def resources = basis.getResources

  @inline def right = basis.getRight

  @inline def rootView = basis.getRootView

  @inline def saveEnabled = basis.isSaveEnabled
  @inline def saveEnabled(p: Boolean) = saveEnabled_=(p)
  @inline def saveEnabled_=(p: Boolean) = { basis.setSaveEnabled(p); basis }
  @inline def enableSave = { basis.setSaveEnabled(true); basis }
  @inline def disableSave = { basis.setSaveEnabled(false); basis }

  @inline def scrollBarStyle = basis.getScrollBarStyle
  @inline def scrollBarStyle(p: Int) = scrollBarStyle_=(p)
  @inline def scrollBarStyle_=(p: Int) = { basis.setScrollBarStyle(p); basis }

  @inline def scrollContainer(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'scrollContainer'")
  @inline def scrollContainer(p: Boolean) = scrollContainer_=(p)
  @inline def scrollContainer_=(p: Boolean) = { basis.setScrollContainer(p); basis }

  @inline def scrollX = basis.getScrollX

  @inline def scrollY = basis.getScrollY

  @inline def scrollbarFadingEnabled = basis.isScrollbarFadingEnabled
  @inline def scrollbarFadingEnabled(p: Boolean) = scrollbarFadingEnabled_=(p)
  @inline def scrollbarFadingEnabled_=(p: Boolean) = { basis.setScrollbarFadingEnabled(p); basis }
  @inline def enableScrollbarFading = { basis.setScrollbarFadingEnabled(true); basis }
  @inline def disableScrollbarFading = { basis.setScrollbarFadingEnabled(false); basis }

  @inline def selected = basis.isSelected
  @inline def selected(p: Boolean) = selected_=(p)
  @inline def selected_=(p: Boolean) = { basis.setSelected(p); basis }

  @inline def solidColor = basis.getSolidColor

  @inline def soundEffectsEnabled = basis.isSoundEffectsEnabled
  @inline def soundEffectsEnabled(p: Boolean) = soundEffectsEnabled_=(p)
  @inline def soundEffectsEnabled_=(p: Boolean) = { basis.setSoundEffectsEnabled(p); basis }
  @inline def enableSoundEffects = { basis.setSoundEffectsEnabled(true); basis }
  @inline def disableSoundEffects = { basis.setSoundEffectsEnabled(false); basis }

  @inline def tag = basis.getTag
  @inline def tag(p: Any) = tag_=(p)
  @inline def tag_=(p: Any) = { basis.setTag(p); basis }

  @inline def top = basis.getTop

  @inline def touchDelegate = basis.getTouchDelegate
  @inline def touchDelegate(p: android.view.TouchDelegate) = touchDelegate_=(p)
  @inline def touchDelegate_=(p: android.view.TouchDelegate) = { basis.setTouchDelegate(p); basis }

  @inline def touchables = basis.getTouchables

  @inline def verticalFadingEdgeEnabled = basis.isVerticalFadingEdgeEnabled
  @inline def verticalFadingEdgeEnabled(p: Boolean) = verticalFadingEdgeEnabled_=(p)
  @inline def verticalFadingEdgeEnabled_=(p: Boolean) = { basis.setVerticalFadingEdgeEnabled(p); basis }
  @inline def enableVerticalFadingEdge = { basis.setVerticalFadingEdgeEnabled(true); basis }
  @inline def disableVerticalFadingEdge = { basis.setVerticalFadingEdgeEnabled(false); basis }

  @inline def verticalFadingEdgeLength = basis.getVerticalFadingEdgeLength

  @inline def verticalScrollBarEnabled = basis.isVerticalScrollBarEnabled
  @inline def verticalScrollBarEnabled(p: Boolean) = verticalScrollBarEnabled_=(p)
  @inline def verticalScrollBarEnabled_=(p: Boolean) = { basis.setVerticalScrollBarEnabled(p); basis }
  @inline def enableVerticalScrollBar = { basis.setVerticalScrollBarEnabled(true); basis }
  @inline def disableVerticalScrollBar = { basis.setVerticalScrollBarEnabled(false); basis }

  @inline def verticalScrollbarWidth = basis.getVerticalScrollbarWidth

  @inline def viewTreeObserver = basis.getViewTreeObserver

  @inline def visibility = basis.getVisibility
  @inline def visibility(p: Int) = visibility_=(p)
  @inline def visibility_=(p: Int) = { basis.setVisibility(p); basis }

  @inline def width = basis.getWidth

  @inline def willNotCacheDrawing(p: Boolean) = willNotCacheDrawing_=(p)
  @inline def willNotCacheDrawing_=(p: Boolean) = { basis.setWillNotCacheDrawing(p); basis }
  @inline def willNotDraw(p: Boolean) = willNotDraw_=(p)
  @inline def willNotDraw_=(p: Boolean) = { basis.setWillNotDraw(p); basis }

  @inline def windowToken = basis.getWindowToken

  @inline def windowVisibility = basis.getWindowVisibility

  @inline def onClick(f: android.view.View => Unit): V = {
    basis.setOnClickListener(new android.view.View.OnClickListener {
      def onClick(p: android.view.View): Unit = { f(p) }
    })
    basis
  }

  @inline def onClick(f: => Unit): V = {
    basis.setOnClickListener(new android.view.View.OnClickListener {
      def onClick(p: android.view.View): Unit = { f }
    })
    basis
  }

  @inline def onCreateContextMenu(f: (android.view.ContextMenu, android.view.View, android.view.ContextMenu.ContextMenuInfo) => Unit): V = {
    basis.setOnCreateContextMenuListener(new android.view.View.OnCreateContextMenuListener {
      def onCreateContextMenu(p1: android.view.ContextMenu, p2: android.view.View, p3: android.view.ContextMenu.ContextMenuInfo): Unit = { f(p1, p2, p3) }
    })
    basis
  }

  @inline def onCreateContextMenu(f: => Unit): V = {
    basis.setOnCreateContextMenuListener(new android.view.View.OnCreateContextMenuListener {
      def onCreateContextMenu(p1: android.view.ContextMenu, p2: android.view.View, p3: android.view.ContextMenu.ContextMenuInfo): Unit = { f }
    })
    basis
  }

  @inline def onFocusChange(f: (android.view.View, Boolean) => Unit): V = {
    basis.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener {
      def onFocusChange(p1: android.view.View, p2: Boolean): Unit = { f(p1, p2) }
    })
    basis
  }

  @inline def onFocusChange(f: => Unit): V = {
    basis.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener {
      def onFocusChange(p1: android.view.View, p2: Boolean): Unit = { f }
    })
    basis
  }

  @inline def onKey(f: (android.view.View, Int, android.view.KeyEvent) => Boolean): V = {
    basis.setOnKeyListener(new android.view.View.OnKeyListener {
      def onKey(p1: android.view.View, p2: Int, p3: android.view.KeyEvent): Boolean = { f(p1, p2, p3) }
    })
    basis
  }

  @inline def onKey(f: => Boolean): V = {
    basis.setOnKeyListener(new android.view.View.OnKeyListener {
      def onKey(p1: android.view.View, p2: Int, p3: android.view.KeyEvent): Boolean = { f }
    })
    basis
  }

  @inline def onLongClick(f: android.view.View => Boolean): V = {
    basis.setOnLongClickListener(new android.view.View.OnLongClickListener {
      def onLongClick(p: android.view.View): Boolean = { f(p) }
    })
    basis
  }

  @inline def onLongClick(f: => Boolean): V = {
    basis.setOnLongClickListener(new android.view.View.OnLongClickListener {
      def onLongClick(p: android.view.View): Boolean = { f }
    })
    basis
  }

  @inline def onTouch(f: (android.view.View, android.view.MotionEvent) => Boolean): V = {
    basis.setOnTouchListener(new android.view.View.OnTouchListener {
      def onTouch(p1: android.view.View, p2: android.view.MotionEvent): Boolean = { f(p1, p2) }
    })
    basis
  }

  @inline def onTouch(f: => Boolean): V = {
    basis.setOnTouchListener(new android.view.View.OnTouchListener {
      def onTouch(p1: android.view.View, p2: android.view.MotionEvent): Boolean = { f }
    })
    basis
  }

}

class RichView(view: View) extends TraitView[View] {
  def basis = view
}

/**
 * Automatically generated concrete helper class of android.view.View.
 */
class SView()(implicit context: android.content.Context, parentVGroup: TraitViewGroup[_] = null)
  extends android.view.View(context) with TraitView[SView] {

  def basis = this
  override val parentViewGroup = parentVGroup

}

object SView {
  def apply[LP <: ViewGroupLayoutParams[_, SView]]()(implicit context: android.content.Context, defaultLayoutParam: SView => LP): SView = {
    val v = new SView
    v.<<.parent.+=(v)
    v
  }

}

/**
 * Automatically generated enriching class of android.view.ViewGroup.
 */
class RichViewGroup[V <: android.view.ViewGroup](val basis: V) extends TraitViewGroup[V]

/**
 * Automatically generated helper trait of android.view.ViewGroup. This contains several property accessors.
 */
trait TraitViewGroup[V <: android.view.ViewGroup] extends TraitView[V] {

  implicit val parentVG = this

  def applyStyle(v: View): View = {
    var viw = v
    if (parentViewGroup != null) viw = parentViewGroup.applyStyle(viw)
    styles.foreach { st =>
      if (st.isDefinedAt(viw)) viw = st(viw)
    }
    viw
  }

  def +=(v: View) = {
    var viw = v
    viw = applyStyle(viw)
    basis.addView(viw)
    basis
  }

  val styles = new ArrayBuffer[View PartialFunction View]

  def style(stl: View PartialFunction View) = {
    styles += stl
    basis
  }

  @inline def addStatesFromChildren(p: Boolean) = addStatesFromChildren_=(p)
  @inline def addStatesFromChildren_=(p: Boolean) = { basis.setAddStatesFromChildren(p); basis }

  @inline def alwaysDrawnWithCacheEnabled = basis.isAlwaysDrawnWithCacheEnabled
  @inline def alwaysDrawnWithCacheEnabled(p: Boolean) = alwaysDrawnWithCacheEnabled_=(p)
  @inline def alwaysDrawnWithCacheEnabled_=(p: Boolean) = { basis.setAlwaysDrawnWithCacheEnabled(p); basis }
  @inline def enableAlwaysDrawnWithCache = { basis.setAlwaysDrawnWithCacheEnabled(true); basis }
  @inline def disableAlwaysDrawnWithCache = { basis.setAlwaysDrawnWithCacheEnabled(false); basis }

  @inline def animationCacheEnabled = basis.isAnimationCacheEnabled
  @inline def animationCacheEnabled(p: Boolean) = animationCacheEnabled_=(p)
  @inline def animationCacheEnabled_=(p: Boolean) = { basis.setAnimationCacheEnabled(p); basis }
  @inline def enableAnimationCache = { basis.setAnimationCacheEnabled(true); basis }
  @inline def disableAnimationCache = { basis.setAnimationCacheEnabled(false); basis }

  @inline def childCount = basis.getChildCount

  @inline def clipChildren(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'clipChildren'")
  @inline def clipChildren(p: Boolean) = clipChildren_=(p)
  @inline def clipChildren_=(p: Boolean) = { basis.setClipChildren(p); basis }

  @inline def clipToPadding(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'clipToPadding'")
  @inline def clipToPadding(p: Boolean) = clipToPadding_=(p)
  @inline def clipToPadding_=(p: Boolean) = { basis.setClipToPadding(p); basis }

  @inline def descendantFocusability = basis.getDescendantFocusability
  @inline def descendantFocusability(p: Int) = descendantFocusability_=(p)
  @inline def descendantFocusability_=(p: Int) = { basis.setDescendantFocusability(p); basis }

  @inline def focusedChild = basis.getFocusedChild

  @inline def layoutAnimation = basis.getLayoutAnimation
  @inline def layoutAnimation(p: android.view.animation.LayoutAnimationController) = layoutAnimation_=(p)
  @inline def layoutAnimation_=(p: android.view.animation.LayoutAnimationController) = { basis.setLayoutAnimation(p); basis }

  @inline def layoutAnimationListener = basis.getLayoutAnimationListener
  @inline def layoutAnimationListener(p: android.view.animation.Animation.AnimationListener) = layoutAnimationListener_=(p)
  @inline def layoutAnimationListener_=(p: android.view.animation.Animation.AnimationListener) = { basis.setLayoutAnimationListener(p); basis }

  @inline def onHierarchyChangeListener(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'onHierarchyChangeListener'")
  @inline def onHierarchyChangeListener(p: android.view.ViewGroup.OnHierarchyChangeListener) = onHierarchyChangeListener_=(p)
  @inline def onHierarchyChangeListener_=(p: android.view.ViewGroup.OnHierarchyChangeListener) = { basis.setOnHierarchyChangeListener(p); basis }

  @inline def persistentDrawingCache = basis.getPersistentDrawingCache
  @inline def persistentDrawingCache(p: Int) = persistentDrawingCache_=(p)
  @inline def persistentDrawingCache_=(p: Int) = { basis.setPersistentDrawingCache(p); basis }

  @inline def onAnimationEnd(f: android.view.animation.Animation => Unit): V = {
    basis.setLayoutAnimationListener(new android.view.animation.Animation.AnimationListener {
      def onAnimationEnd(p: android.view.animation.Animation): Unit = { f(p) }
      def onAnimationRepeat(p: android.view.animation.Animation): Unit = {}
      def onAnimationStart(p: android.view.animation.Animation): Unit = {}
    })
    basis
  }

  @inline def onAnimationEnd(f: => Unit): V = {
    basis.setLayoutAnimationListener(new android.view.animation.Animation.AnimationListener {
      def onAnimationEnd(p: android.view.animation.Animation): Unit = { f }
      def onAnimationRepeat(p: android.view.animation.Animation): Unit = {}
      def onAnimationStart(p: android.view.animation.Animation): Unit = {}
    })
    basis
  }

  @inline def onAnimationRepeat(f: android.view.animation.Animation => Unit): V = {
    basis.setLayoutAnimationListener(new android.view.animation.Animation.AnimationListener {
      def onAnimationEnd(p: android.view.animation.Animation): Unit = {}
      def onAnimationRepeat(p: android.view.animation.Animation): Unit = { f(p) }
      def onAnimationStart(p: android.view.animation.Animation): Unit = {}
    })
    basis
  }

  @inline def onAnimationRepeat(f: => Unit): V = {
    basis.setLayoutAnimationListener(new android.view.animation.Animation.AnimationListener {
      def onAnimationEnd(p: android.view.animation.Animation): Unit = {}
      def onAnimationRepeat(p: android.view.animation.Animation): Unit = { f }
      def onAnimationStart(p: android.view.animation.Animation): Unit = {}
    })
    basis
  }

  @inline def onAnimationStart(f: android.view.animation.Animation => Unit): V = {
    basis.setLayoutAnimationListener(new android.view.animation.Animation.AnimationListener {
      def onAnimationEnd(p: android.view.animation.Animation): Unit = {}
      def onAnimationRepeat(p: android.view.animation.Animation): Unit = {}
      def onAnimationStart(p: android.view.animation.Animation): Unit = { f(p) }
    })
    basis
  }

  @inline def onAnimationStart(f: => Unit): V = {
    basis.setLayoutAnimationListener(new android.view.animation.Animation.AnimationListener {
      def onAnimationEnd(p: android.view.animation.Animation): Unit = {}
      def onAnimationRepeat(p: android.view.animation.Animation): Unit = {}
      def onAnimationStart(p: android.view.animation.Animation): Unit = { f }
    })
    basis
  }

  @inline def onChildViewAdded(f: (android.view.View, android.view.View) => Unit): V = {
    basis.setOnHierarchyChangeListener(new android.view.ViewGroup.OnHierarchyChangeListener {
      def onChildViewAdded(p1: android.view.View, p2: android.view.View): Unit = { f(p1, p2) }
      def onChildViewRemoved(p1: android.view.View, p2: android.view.View): Unit = {}
    })
    basis
  }

  @inline def onChildViewAdded(f: => Unit): V = {
    basis.setOnHierarchyChangeListener(new android.view.ViewGroup.OnHierarchyChangeListener {
      def onChildViewAdded(p1: android.view.View, p2: android.view.View): Unit = { f }
      def onChildViewRemoved(p1: android.view.View, p2: android.view.View): Unit = {}
    })
    basis
  }

  @inline def onChildViewRemoved(f: (android.view.View, android.view.View) => Unit): V = {
    basis.setOnHierarchyChangeListener(new android.view.ViewGroup.OnHierarchyChangeListener {
      def onChildViewAdded(p1: android.view.View, p2: android.view.View): Unit = {}
      def onChildViewRemoved(p1: android.view.View, p2: android.view.View): Unit = { f(p1, p2) }
    })
    basis
  }

  @inline def onChildViewRemoved(f: => Unit): V = {
    basis.setOnHierarchyChangeListener(new android.view.ViewGroup.OnHierarchyChangeListener {
      def onChildViewAdded(p1: android.view.View, p2: android.view.View): Unit = {}
      def onChildViewRemoved(p1: android.view.View, p2: android.view.View): Unit = { f }
    })
    basis
  }
}

trait ViewGroupLayoutParams[LP <: ViewGroupLayoutParams[_, _], V <: View] extends ViewGroup.LayoutParams {
  def basis: LP

  def fill = {
    width = ViewGroup.LayoutParams.MATCH_PARENT
    height = ViewGroup.LayoutParams.MATCH_PARENT
    basis
  }
  def wrap = {
    width = ViewGroup.LayoutParams.WRAP_CONTENT
    height = ViewGroup.LayoutParams.WRAP_CONTENT
    basis
  }

  def parent: TraitViewGroup[_]

  def >> : V
}

trait ViewGroupMarginLayoutParams[LP <: ViewGroupMarginLayoutParams[_, _], V <: View] extends ViewGroup.MarginLayoutParams with ViewGroupLayoutParams[LP, V] {

  def marginBottom(size: Int) = {
    bottomMargin = size
    basis
  }

  def marginTop(size: Int) = {
    topMargin = size
    basis
  }

  def marginLeft(size: Int) = {
    leftMargin = size
    basis
  }

  def marginRight(size: Int) = {
    rightMargin = size
    basis
  }

  def margin(size: Int) = {
    bottomMargin = size
    topMargin = size
    leftMargin = size
    rightMargin = size
    basis
  }

  def margin(top: Int, right: Int, bottom: Int, left: Int) = {
    bottomMargin = bottom
    topMargin = top
    leftMargin = left
    rightMargin = right
    basis
  }
}

/**
 * Automatically generated enriching class of android.view.Menu.
 */
class RichMenu[V <: android.view.Menu](val basis: V) extends TraitMenu[V]

/**
 * Automatically generated helper trait of android.view.Menu. This contains several property accessors.
 */
trait TraitMenu[V <: android.view.Menu] {

  def basis: V

  @inline def +=(txt: CharSequence) = basis.add(txt)

  @inline def inflate(id: Int)(implicit activity: Activity) = {
    val inflater = activity.getMenuInflater
    inflater.inflate(id, basis)
    true
  }

  @inline def qwertyMode(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'qwertyMode'")
  @inline def qwertyMode(p: Boolean) = qwertyMode_=(p)
  @inline def qwertyMode_=(p: Boolean) = { basis.setQwertyMode(p); basis }

}

/**
 * Automatically generated enriching class of android.view.ContextMenu.
 */
class RichContextMenu[V <: android.view.ContextMenu](val basis: V) extends TraitContextMenu[V]

/**
 * Automatically generated helper trait of android.view.ContextMenu. This contains several property accessors.
 */
trait TraitContextMenu[V <: android.view.ContextMenu] {

  def basis: V

  @inline def headerIcon(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'headerIcon'")
  @inline def headerIcon(p: Int) = headerIcon_=(p)
  @inline def headerIcon_=(p: Int) = { basis.setHeaderIcon(p); basis }
  @inline def headerIcon(p: android.graphics.drawable.Drawable) = headerIcon_=(p)
  @inline def headerIcon_=(p: android.graphics.drawable.Drawable) = { basis.setHeaderIcon(p); basis }

  @inline def headerTitle(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'headerTitle'")
  @inline def headerTitle(p: Int) = headerTitle_=(p)
  @inline def headerTitle_=(p: Int) = { basis.setHeaderTitle(p); basis }
  @inline def headerTitle(p: java.lang.CharSequence) = headerTitle_=(p)
  @inline def headerTitle_=(p: java.lang.CharSequence) = { basis.setHeaderTitle(p); basis }

  @inline def headerView(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'headerView'")
  @inline def headerView(p: android.view.View) = headerView_=(p)
  @inline def headerView_=(p: android.view.View) = { basis.setHeaderView(p); basis }

}

/**
 * Automatically generated enriching class of android.view.SurfaceView.
 */
class RichSurfaceView[V <: android.view.SurfaceView](val basis: V) extends TraitSurfaceView[V]

/**
 * Automatically generated helper trait of android.view.SurfaceView. This contains several property accessors.
 */
trait TraitSurfaceView[V <: android.view.SurfaceView] extends TraitView[V] {

  @inline def holder = basis.getHolder

  @inline def zOrderMediaOverlay(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'zOrderMediaOverlay'")
  @inline def zOrderMediaOverlay(p: Boolean) = zOrderMediaOverlay_=(p)
  @inline def zOrderMediaOverlay_=(p: Boolean) = { basis.setZOrderMediaOverlay(p); basis }

  @inline def zOrderOnTop(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'zOrderOnTop'")
  @inline def zOrderOnTop(p: Boolean) = zOrderOnTop_=(p)
  @inline def zOrderOnTop_=(p: Boolean) = { basis.setZOrderOnTop(p); basis }

}

/**
 * Automatically generated concrete helper class of android.view.SurfaceView.
 */
class SSurfaceView()(implicit context: android.content.Context, parentVGroup: TraitViewGroup[_] = null)
  extends android.view.SurfaceView(context) with TraitSurfaceView[SSurfaceView] {

  def basis = this
  override val parentViewGroup = parentVGroup

}

object SSurfaceView {
  def apply[LP <: ViewGroupLayoutParams[_, SSurfaceView]]()(implicit context: android.content.Context, defaultLayoutParam: SSurfaceView => LP): SSurfaceView = {
    val v = new SSurfaceView
    v.<<.parent.+=(v)
    v
  }

}

/**
 * Automatically generated enriching class of android.view.ViewStub.
 */
class RichViewStub[V <: android.view.ViewStub](val basis: V) extends TraitViewStub[V]

/**
 * Automatically generated helper trait of android.view.ViewStub. This contains several property accessors.
 */
trait TraitViewStub[V <: android.view.ViewStub] extends TraitView[V] {

  @inline def inflatedId = basis.getInflatedId
  @inline def inflatedId(p: Int) = inflatedId_=(p)
  @inline def inflatedId_=(p: Int) = { basis.setInflatedId(p); basis }

  @inline def layoutResource = basis.getLayoutResource
  @inline def layoutResource(p: Int) = layoutResource_=(p)
  @inline def layoutResource_=(p: Int) = { basis.setLayoutResource(p); basis }

  @inline def onInflateListener(implicit no: NoGetterForThisProperty): Nothing = throw new Error("Android does not support the getter for 'onInflateListener'")
  @inline def onInflateListener(p: android.view.ViewStub.OnInflateListener) = onInflateListener_=(p)
  @inline def onInflateListener_=(p: android.view.ViewStub.OnInflateListener) = { basis.setOnInflateListener(p); basis }

  @inline def onInflate(f: (android.view.ViewStub, android.view.View) => Unit): V = {
    basis.setOnInflateListener(new android.view.ViewStub.OnInflateListener {
      def onInflate(p1: android.view.ViewStub, p2: android.view.View): Unit = { f(p1, p2) }
    })
    basis
  }

  @inline def onInflate(f: => Unit): V = {
    basis.setOnInflateListener(new android.view.ViewStub.OnInflateListener {
      def onInflate(p1: android.view.ViewStub, p2: android.view.View): Unit = { f }
    })
    basis
  }
}

object Widgets {
  implicit def view2RichView(v: View) = new RichView(v)
  implicit def activity2RichActivity(activity: Activity) = new RichActivity(activity)
}