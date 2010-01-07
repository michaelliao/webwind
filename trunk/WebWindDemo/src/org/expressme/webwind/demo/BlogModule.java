package org.expressme.webwind.demo;

import org.expressme.webwind.demo.tx.TxInterceptor;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * Module for Guice.
 */
public class BlogModule implements Module {

    public void configure(Binder binder) {
        binder.bind(Blog.class).asEagerSingleton();
        binder.bind(TxInterceptor.class).asEagerSingleton();
    }

}
