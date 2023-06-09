// Generated by data binding compiler. Do not edit!
package com.example.convergenceapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.convergenceapp.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentHomeBinding extends ViewDataBinding {
  @NonNull
  public final TextInputLayout anyFamilyVisib;

  @NonNull
  public final ImageView backclick;

  @NonNull
  public final CardView bankDetails;

  @NonNull
  public final TextInputLayout benAvaiVisi;

  @NonNull
  public final TextInputLayout benvis;

  @NonNull
  public final MaterialButton btnSave;

  @NonNull
  public final EditText edtMobile;

  @NonNull
  public final TextView fatherName;

  @NonNull
  public final LinearLayout fathervis;

  @NonNull
  public final LinearLayout llBank;

  @NonNull
  public final TextInputLayout memberVisi;

  @NonNull
  public final LinearLayout mobVis;

  @NonNull
  public final TextView motherName;

  @NonNull
  public final LinearLayout motherNamevis;

  @NonNull
  public final TextInputLayout ngpVisib;

  @NonNull
  public final TextInputLayout nrlmVillVissib;

  @NonNull
  public final LinearLayout othermember;

  @NonNull
  public final TextInputLayout reasonVisi;

  @NonNull
  public final TextInputLayout shgVisi;

  @NonNull
  public final AutoCompleteTextView spinnerBenAvail;

  @NonNull
  public final AutoCompleteTextView spinnerBeneficiary;

  @NonNull
  public final AutoCompleteTextView spinnerGp;

  @NonNull
  public final AutoCompleteTextView spinnerInShg;

  @NonNull
  public final AutoCompleteTextView spinnerMemberName;

  @NonNull
  public final AutoCompleteTextView spinnerNrlmGp;

  @NonNull
  public final AutoCompleteTextView spinnerNrlmVillage;

  @NonNull
  public final AutoCompleteTextView spinnerReason;

  @NonNull
  public final AutoCompleteTextView spinnerScheme;

  @NonNull
  public final AutoCompleteTextView spinnerShgName;

  @NonNull
  public final AutoCompleteTextView spinnerVillage;

  @NonNull
  public final AutoCompleteTextView spinnerWilling;

  @NonNull
  public final TextView textView;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final TextInputLayout villageVis;

  @NonNull
  public final TextInputLayout willingVisib;

  protected FragmentHomeBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextInputLayout anyFamilyVisib, ImageView backclick, CardView bankDetails,
      TextInputLayout benAvaiVisi, TextInputLayout benvis, MaterialButton btnSave,
      EditText edtMobile, TextView fatherName, LinearLayout fathervis, LinearLayout llBank,
      TextInputLayout memberVisi, LinearLayout mobVis, TextView motherName,
      LinearLayout motherNamevis, TextInputLayout ngpVisib, TextInputLayout nrlmVillVissib,
      LinearLayout othermember, TextInputLayout reasonVisi, TextInputLayout shgVisi,
      AutoCompleteTextView spinnerBenAvail, AutoCompleteTextView spinnerBeneficiary,
      AutoCompleteTextView spinnerGp, AutoCompleteTextView spinnerInShg,
      AutoCompleteTextView spinnerMemberName, AutoCompleteTextView spinnerNrlmGp,
      AutoCompleteTextView spinnerNrlmVillage, AutoCompleteTextView spinnerReason,
      AutoCompleteTextView spinnerScheme, AutoCompleteTextView spinnerShgName,
      AutoCompleteTextView spinnerVillage, AutoCompleteTextView spinnerWilling, TextView textView,
      Toolbar toolbar, TextInputLayout villageVis, TextInputLayout willingVisib) {
    super(_bindingComponent, _root, _localFieldCount);
    this.anyFamilyVisib = anyFamilyVisib;
    this.backclick = backclick;
    this.bankDetails = bankDetails;
    this.benAvaiVisi = benAvaiVisi;
    this.benvis = benvis;
    this.btnSave = btnSave;
    this.edtMobile = edtMobile;
    this.fatherName = fatherName;
    this.fathervis = fathervis;
    this.llBank = llBank;
    this.memberVisi = memberVisi;
    this.mobVis = mobVis;
    this.motherName = motherName;
    this.motherNamevis = motherNamevis;
    this.ngpVisib = ngpVisib;
    this.nrlmVillVissib = nrlmVillVissib;
    this.othermember = othermember;
    this.reasonVisi = reasonVisi;
    this.shgVisi = shgVisi;
    this.spinnerBenAvail = spinnerBenAvail;
    this.spinnerBeneficiary = spinnerBeneficiary;
    this.spinnerGp = spinnerGp;
    this.spinnerInShg = spinnerInShg;
    this.spinnerMemberName = spinnerMemberName;
    this.spinnerNrlmGp = spinnerNrlmGp;
    this.spinnerNrlmVillage = spinnerNrlmVillage;
    this.spinnerReason = spinnerReason;
    this.spinnerScheme = spinnerScheme;
    this.spinnerShgName = spinnerShgName;
    this.spinnerVillage = spinnerVillage;
    this.spinnerWilling = spinnerWilling;
    this.textView = textView;
    this.toolbar = toolbar;
    this.villageVis = villageVis;
    this.willingVisib = willingVisib;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_home, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentHomeBinding>inflateInternal(inflater, R.layout.fragment_home, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_home, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentHomeBinding>inflateInternal(inflater, R.layout.fragment_home, null, false, component);
  }

  public static FragmentHomeBinding bind(@NonNull View view) {
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
  public static FragmentHomeBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentHomeBinding)bind(component, view, R.layout.fragment_home);
  }
}
