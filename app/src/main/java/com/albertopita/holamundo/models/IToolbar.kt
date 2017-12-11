package com.albertopita.holamundo.models
import android.support.v7.widget.Toolbar


/**
 * Created by pita on 09/12/17.
 */
interface IToolbar{
    fun toolbarToLoad(toolbar: Toolbar?)
    fun enableHomeDisplay(value:Boolean)
}