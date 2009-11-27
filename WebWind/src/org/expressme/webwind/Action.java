package org.expressme.webwind;

import java.lang.reflect.Method;

/**
 * Internal class which holds object instance and method.
 * 
 * @author Michael Liao (askxuefeng@gmail.com)
 */
class Action {

    public final Object instance;
    public final Method method;
    public final Class<?>[] arguments;

    public Action(Object instance, Method method) {
        this.instance = instance;
        this.method = method;
        this.arguments = method.getParameterTypes();
    }

}
