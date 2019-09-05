package edu.jrubiralta.portalbdn.ui.activity

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjected
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.lazy
import edu.jrubiralta.portalbdn.App
import edu.jrubiralta.portalbdn.R
import edu.jrubiralta.portalbdn.presenter.BasePresenter
import edu.jrubiralta.portalbdn.ui.view.View

abstract class BaseActivity<P, V>
    : AppCompatActivity(),
    View, KodeinInjected where P : BasePresenter<V>, V : View {

    abstract val presenter: P

    abstract val layoutResourceId: Int

    override val injector = KodeinInjector()

    abstract val activityModule: Kodein.Module

    val kodein by Kodein.lazy {
        extend((application as App).kodein)
        import(activityModule)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResourceId)
        init()
    }

    public override fun onRestoreInstanceState(inState: Bundle) {
        super.onRestoreInstanceState(inState)
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

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    protected open fun replaceFragment(containerId: Int, fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(containerId, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    protected open fun removeFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.remove(fragment)
        fragmentTransaction.commitAllowingStateLoss()
    }

    override fun getCtx(): Context = this

}
