package ren.daxu.base;


/**
 * 0层基础Presenter
 * @param <V>
 * @param <M>
 */
public abstract class BasePresenter<V,M> {

     public abstract void destory();

     public V v;
     public M m;

     public void init(V v,M m){
          this.v = v;
          this.m = m;
     }


}
