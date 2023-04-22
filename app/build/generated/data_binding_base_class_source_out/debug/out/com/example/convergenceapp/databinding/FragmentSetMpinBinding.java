// Generated by data binding compiler. Do not edit!
package com.example.convergenceapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.chaos.view.PinView;
import com.example.convergenceapp.R;
import com.google.android.material.button.MaterialButton;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentSetMpinBinding extends ViewDataBinding {
  @NonNull
  public final MaterialButton btnSetMpin;

  @NonNull
  public final PinView pinviewFirst;

  @NonNull
  public final PinView pinviewSecond;

  protected FragmentSetMpinBinding(Object _bindingComponent, View _root, int _localFieldCount,
      MaterialButton btnSetMpin, PinView pinviewFirst, PinView pinviewSecond) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnSetMpin = btnSetMpin;
    this.pinviewFirst = pinviewFirst;
    this.pinviewSecond = pinviewSecond;
  }

  @NonNull
  public static FragmentSetMpinBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_set_mpin, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSetMpinBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentSetMpinBinding>inflateInternal(inflater, R.layout.fragment_set_mpin, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSetMpinBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_set_mpin, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSetMpinBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSetMpinBinding>inflateInternal(inflater, R.layout.fragment_set_mpin, null, false, component);
  }

  public static FragmentSetMpinBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentSetMpinBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentSetMpinBinding)bind(component, view, R.layout.fragment_set_mpin);
  }
}