package org.ffmmx.androidscala

import android.app._
import android.view._
import android.widget._
import scala.collection.mutable.ArrayBuffer
import android.content._
import android.view._
import View._
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



object Widgets {
	implicit def view2RichView(v: View) = new RichView(v)
	implicit def activity2RichActivity(activity: Activity) = new RichActivity(activity)
}