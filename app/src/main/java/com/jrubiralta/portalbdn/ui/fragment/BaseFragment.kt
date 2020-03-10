package com.jrubiralta.portalbdn.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjected
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.lazy
import com.jrubiralta.portalbdn.presenter.BasePresenter
import com.jrubiralta.portalbdn.ui.activity.BaseActivity
import com.jrubiralta.portalbdn.ui.view.View


abstract class BaseFragment<P, V>
    : Fragment(),
        View, KodeinInjected where P : BasePresenter<V>, V : View {

    abstract val presenter: P

    abstract val layoutResourceId: Int

    override val injector = KodeinInjector()

    abstract val fragmentModule: Kodein.Module

    val kodein by Kodein.lazy {
        extend((activity as BaseActivity<*, *>).kodein)
        import(fragmentModule)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): android.view.View? {
        return inflater.inflate(layoutResourceId, container, false)
    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initDI()
        initPresenter()
    }

    private fun initDI() = inject(kodein)

    private fun initPresenter() = presenter.init()

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }

    override fun onPause() {
        super.onPause()
        presenter.pause()
    }

    override fun onStop() {
        super.onStop()
        presenter.stop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.destroy()
    }

    override fun getCtx() = context!!

    protected open fun replaceFragment(containerId: Int, fragment: Fragment) {
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.replace(containerId, fragment)
        fragmentTransaction.commit()
    }

    protected open fun replaceFragmentWithoutBackstack(containerId: Int, fragment: Fragment) {
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        val supportFragmentManager = activity!!.supportFragmentManager
        supportFragmentManager.popBackStack()
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.replace(containerId, fragment)
        fragmentTransaction.commit()
    }

    open fun isBackAllowed() : Boolean {
        return true
    }
}
