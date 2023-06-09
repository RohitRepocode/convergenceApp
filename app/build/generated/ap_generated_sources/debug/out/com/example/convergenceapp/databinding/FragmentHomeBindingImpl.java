package com.example.convergenceapp.databinding;
import com.example.convergenceapp.R;
import com.example.convergenceapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentHomeBindingImpl extends FragmentHomeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 1);
        sViewsWithIds.put(R.id.backclick, 2);
        sViewsWithIds.put(R.id.textView, 3);
        sViewsWithIds.put(R.id.spinner_scheme, 4);
        sViewsWithIds.put(R.id.spinner_gp, 5);
        sViewsWithIds.put(R.id.village_vis, 6);
        sViewsWithIds.put(R.id.spinner_village, 7);
        sViewsWithIds.put(R.id.benvis, 8);
        sViewsWithIds.put(R.id.spinner_beneficiary, 9);
        sViewsWithIds.put(R.id.fathervis, 10);
        sViewsWithIds.put(R.id.father_name, 11);
        sViewsWithIds.put(R.id.mother_namevis, 12);
        sViewsWithIds.put(R.id.mother_name, 13);
        sViewsWithIds.put(R.id.bank_details, 14);
        sViewsWithIds.put(R.id.othermember, 15);
        sViewsWithIds.put(R.id.llBank, 16);
        sViewsWithIds.put(R.id.mob_vis, 17);
        sViewsWithIds.put(R.id.edt_mobile, 18);
        sViewsWithIds.put(R.id.ben_avai_visi, 19);
        sViewsWithIds.put(R.id.spinner_ben_avail, 20);
        sViewsWithIds.put(R.id.any_family_visib, 21);
        sViewsWithIds.put(R.id.spinner_in_shg, 22);
        sViewsWithIds.put(R.id.lis_of_familyMember, 23);
        sViewsWithIds.put(R.id.Spinner_family, 24);
        sViewsWithIds.put(R.id.member_outerLay, 25);
        sViewsWithIds.put(R.id.member_nameET, 26);
        sViewsWithIds.put(R.id.ngp_visib, 27);
        sViewsWithIds.put(R.id.spinner_nrlm_gp, 28);
        sViewsWithIds.put(R.id.nrlm_vill_vissib, 29);
        sViewsWithIds.put(R.id.spinner_nrlm_village, 30);
        sViewsWithIds.put(R.id.shg_visi, 31);
        sViewsWithIds.put(R.id.spinner_shg_name, 32);
        sViewsWithIds.put(R.id.member_visi, 33);
        sViewsWithIds.put(R.id.spinner_member_name, 34);
        sViewsWithIds.put(R.id.willing_visib, 35);
        sViewsWithIds.put(R.id.spinner_willing, 36);
        sViewsWithIds.put(R.id.reason_visi, 37);
        sViewsWithIds.put(R.id.spinner_reason, 38);
        sViewsWithIds.put(R.id.btn_save, 39);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 40, sIncludes, sViewsWithIds));
    }
    private FragmentHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.AutoCompleteTextView) bindings[24]
            , (com.google.android.material.textfield.TextInputLayout) bindings[21]
            , (android.widget.ImageView) bindings[2]
            , (androidx.cardview.widget.CardView) bindings[14]
            , (com.google.android.material.textfield.TextInputLayout) bindings[19]
            , (com.google.android.material.textfield.TextInputLayout) bindings[8]
            , (com.google.android.material.button.MaterialButton) bindings[39]
            , (android.widget.EditText) bindings[18]
            , (android.widget.TextView) bindings[11]
            , (android.widget.LinearLayout) bindings[10]
            , (com.google.android.material.textfield.TextInputLayout) bindings[23]
            , (android.widget.LinearLayout) bindings[16]
            , (com.google.android.material.textfield.TextInputEditText) bindings[26]
            , (com.google.android.material.textfield.TextInputLayout) bindings[25]
            , (com.google.android.material.textfield.TextInputLayout) bindings[33]
            , (android.widget.LinearLayout) bindings[17]
            , (android.widget.TextView) bindings[13]
            , (android.widget.LinearLayout) bindings[12]
            , (com.google.android.material.textfield.TextInputLayout) bindings[27]
            , (com.google.android.material.textfield.TextInputLayout) bindings[29]
            , (android.widget.LinearLayout) bindings[15]
            , (com.google.android.material.textfield.TextInputLayout) bindings[37]
            , (com.google.android.material.textfield.TextInputLayout) bindings[31]
            , (android.widget.AutoCompleteTextView) bindings[20]
            , (android.widget.AutoCompleteTextView) bindings[9]
            , (android.widget.AutoCompleteTextView) bindings[5]
            , (android.widget.AutoCompleteTextView) bindings[22]
            , (android.widget.AutoCompleteTextView) bindings[34]
            , (android.widget.AutoCompleteTextView) bindings[28]
            , (android.widget.AutoCompleteTextView) bindings[30]
            , (android.widget.AutoCompleteTextView) bindings[38]
            , (android.widget.AutoCompleteTextView) bindings[4]
            , (android.widget.AutoCompleteTextView) bindings[32]
            , (android.widget.AutoCompleteTextView) bindings[7]
            , (android.widget.AutoCompleteTextView) bindings[36]
            , (android.widget.TextView) bindings[3]
            , (androidx.appcompat.widget.Toolbar) bindings[1]
            , (com.google.android.material.textfield.TextInputLayout) bindings[6]
            , (com.google.android.material.textfield.TextInputLayout) bindings[35]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}