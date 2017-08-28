package com.nbs.weatherforecast.base

/**
 * Created by sidiqpermana on 8/28/17.
 */
interface IBasePresenter<in T: BaseView> {
    fun onAttach(view: T)
    fun onDetach()
}