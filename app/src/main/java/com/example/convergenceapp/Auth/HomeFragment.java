package com.example.convergenceapp.Auth;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.convergenceapp.Mpin.SetMpinFragmentDirections;
import com.example.convergenceapp.R;
import com.example.convergenceapp.database.AppDatabase;
import com.example.convergenceapp.database.dbBean.BeneficiaryBean;
import com.example.convergenceapp.database.dbBean.GpBean;
import com.example.convergenceapp.database.dbBean.MemberBean;
import com.example.convergenceapp.database.dbBean.NrlmDataBean;
import com.example.convergenceapp.database.dbBean.NrlmVillageBean;
import com.example.convergenceapp.database.dbBean.ReasonBean;
import com.example.convergenceapp.database.dbBean.ShgBean;
import com.example.convergenceapp.database.dbBean.VillageBean;
import com.example.convergenceapp.databinding.DialogBankDetailsBinding;
import com.example.convergenceapp.databinding.FragmentHomeBinding;
import com.example.convergenceapp.utils.DialogFactory;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    ArrayAdapter<String> selectionFromAdapter,selectionFromAdapter1,gpAdapter,nrlmGpAdapter,nrlmVillageAdapter,shgAdapter,memberAdapter,reasonAdapter,wiilingAdapter,villageAdapter,beneficiaryAdapter;
Toolbar toolbar_home;
    List<String> list,list1,gpName,villageName,beneficiaryName,nrlmGpName,nrlmGpCode,nrlmVillageName,nrlmVillageCode,shgName,shgCode,memberName,memberCode,reasonList;

    String selectedGp,selectedVillage,selectedBeneficiary,selectedWIlling
            ,selectedInShg,selectedBenAvailable,beneficiaryAccNo,beneficiaryId,selectedReason,
            beneficiaryBankName,beneficiaryBranchname,beneficiaryMobileNo, ifscCode,
    selectedNrlmGpCode,selectedNrlmGp,selectedNrlmVillageCode,selectedNrlmVillage,selectedShg,selectedShgCode,
            selectedmemberCode,selectedmember,fatherName,motherName;

    public NavController navController;


    AppDatabase appDatabase;

    List<BeneficiaryBean> beneficiaryBeans;
    List<NrlmVillageBean> nrlmVillageBeans;
    List<ShgBean> shgBeans;
    List<MemberBean> memberBeans;
    List<ReasonBean> reasonBeans;


    private FragmentHomeBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appDatabase= AppDatabase.getDatabase(getContext());

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentHomeBinding.inflate(inflater);

        toolbar_home= binding.toolbar;
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_home);


        list = new ArrayList<String>();
        list.add("Yes");
        list.add("No");

        list1 = new ArrayList<String>();
        list1.add("Yes (NRLM)");
        list1.add("Yes (NON NRLM)");
        list1.add("No");



        //GET GP NAME

        List<GpBean> gpBeans = appDatabase.pmaygInfoDao().getGPList();
        gpName = new ArrayList<String>();

        for (int i=0;i<gpBeans.size();i++){
            gpName.add(gpBeans.get(i).getGpName());

        }
        //GET Reason

        List<ReasonBean> reasonBeans = appDatabase.reasonInfoDao().getReason();
        reasonList = new ArrayList<String>();

        for (int i=0;i<reasonBeans.size();i++){
            reasonList.add(reasonBeans.get(i).getReason());

        }





//GET Nrlm GP NAME

        List<NrlmDataBean> nrlmDataBeans = appDatabase.nrlmInfoDao().getNrlmList();
        nrlmGpName= new ArrayList<String>();
        nrlmGpCode= new ArrayList<String>();


        for (int i=0;i<nrlmDataBeans.size();i++){
            nrlmGpName.add(nrlmDataBeans.get(i).getGpName());
            nrlmGpCode.add(nrlmDataBeans.get(i).getGpCode());


        }


//Gp selection

        gpAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_text,gpName );
        binding.spinnerGp.setAdapter(gpAdapter);
        gpAdapter.notifyDataSetChanged();

        binding.spinnerGp.setOnItemClickListener((adapterView, view1, i, l) -> {
            selectedGp= gpName.get(i);
         //   Toast.makeText(getContext(), selectedGp, Toast.LENGTH_SHORT).show();
             //GET village NAME

        List<VillageBean> villageBeans = appDatabase.pmaygInfoDao().getVillageList(selectedGp);
        villageName = new ArrayList<String>();

        for (int j=0;j<villageBeans.size();j++){
            villageName.add(villageBeans.get(j).getVillageName());
           // Toast.makeText(getContext(), villageBeans.get(j).getVillageName(), Toast.LENGTH_SHORT).show();

        }


            villageAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_text,villageName );
            binding.spinnerVillage.setAdapter(villageAdapter);
            villageAdapter.notifyDataSetChanged();



            //  ----Set Visibility-----------
            binding.villageVis.setVisibility(View.VISIBLE);
            binding.fathervis.setVisibility(View.GONE);
            binding.motherNamevis.setVisibility(View.GONE);
            binding.benvis.setVisibility(View.GONE);
            binding.bankDetails.setVisibility(View.GONE);
            binding.mobVis.setVisibility(View.GONE);
            binding.benAvaiVisi.setVisibility(View.GONE);
            binding.anyFamilyVisib.setVisibility(View.GONE);
            binding.nrlmVillVissib.setVisibility(View.GONE);
            binding.ngpVisib.setVisibility(View.GONE);
            binding.shgVisi.setVisibility(View.GONE);
            binding.memberVisi.setVisibility(View.GONE);
            binding.btnSave.setVisibility(View.GONE);
            binding.willingVisib.setVisibility(View.GONE);
            binding.reasonVisi.setVisibility(View.GONE);




            //-----Seleted data set blank----
            binding.spinnerVillage.setText("");
            binding.spinnerBeneficiary.setText("");
            binding.spinnerBenAvail.setText("");
            binding.spinnerNrlmVillage.setText("");
            binding.spinnerNrlmGp.setText("");
            binding.spinnerInShg.setText("");
            binding.spinnerMemberName.setText("");
            binding.spinnerWilling.setText("");
            binding.spinnerReason.setText("");


            selectedVillage= "";selectedBeneficiary= "";selectedWIlling= "";
            selectedInShg= "";selectedBenAvailable= "";beneficiaryAccNo= "";beneficiaryId= "";selectedReason= "";
            beneficiaryBankName= "";beneficiaryBranchname= "";beneficiaryMobileNo= ""; ifscCode="";
            selectedNrlmGpCode= "";selectedNrlmGp= "";selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
            selectedShgCode= "";selectedmemberCode= "";selectedmember= "";beneficiaryMobileNo= "";



            gpAdapter.notifyDataSetChanged();

        });


        //Village selection



        //GET village NAME




        binding.spinnerVillage.setOnItemClickListener((adapterView, view1, i, l) -> {
            selectedVillage= villageName.get(i);
            //GET beneficiary NAME

             beneficiaryBeans = appDatabase.pmaygInfoDao().getBenDetailsList(selectedVillage);
            beneficiaryName = new ArrayList<String>();


            for (int j=0;j<beneficiaryBeans.size();j++){
                beneficiaryName.add(beneficiaryBeans.get(j).getBenName());
              //  Toast.makeText(getContext(), beneficiaryBeans.get(i).getBenName(), Toast.LENGTH_SHORT).show();

            }

            // set Visibility
            binding.benvis.setVisibility(View.VISIBLE);
            binding.bankDetails.setVisibility(View.GONE);
            binding.mobVis.setVisibility(View.GONE);
            binding.benAvaiVisi.setVisibility(View.GONE);
            binding.anyFamilyVisib.setVisibility(View.GONE);
            binding.nrlmVillVissib.setVisibility(View.GONE);
            binding.ngpVisib.setVisibility(View.GONE);
            binding.shgVisi.setVisibility(View.GONE);
            binding.fathervis.setVisibility(View.GONE);
            binding.motherNamevis.setVisibility(View.GONE);
            binding.memberVisi.setVisibility(View.GONE);
            binding.btnSave.setVisibility(View.GONE);
            binding.willingVisib.setVisibility(View.GONE);
            binding.reasonVisi.setVisibility(View.GONE);

            //-----Seleted data set blank----


            binding.spinnerBeneficiary.setText("");
            binding.spinnerBenAvail.setText("");
            binding.spinnerNrlmVillage.setText("");
            binding.spinnerNrlmGp.setText("");
            binding.spinnerInShg.setText("");
            binding.spinnerMemberName.setText("");
            binding.spinnerWilling.setText("");
            binding.spinnerReason.setText("");


            selectedBeneficiary= "";selectedWIlling= "";
            selectedInShg= "";selectedBenAvailable= "";beneficiaryAccNo= "";beneficiaryId= "";selectedReason= "";
            beneficiaryBankName= "";beneficiaryBranchname= "";beneficiaryMobileNo= ""; ifscCode="";
            selectedNrlmGpCode= "";selectedNrlmGp= "";selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
            selectedShgCode= "";selectedmemberCode= "";selectedmember= "";beneficiaryMobileNo= "";



            beneficiaryAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_text,beneficiaryName );
            binding.spinnerBeneficiary.setAdapter(beneficiaryAdapter);
            beneficiaryAdapter.notifyDataSetChanged();

            villageAdapter.notifyDataSetChanged();


        });




        //Beneficiary selection




        binding.spinnerBeneficiary.setOnItemClickListener((adapterView, view1, i, l) -> {
            selectedBeneficiary= beneficiaryName.get(i);
            beneficiaryId= beneficiaryBeans.get(i).getBenId();
            beneficiaryAccNo= beneficiaryBeans.get(i).getBenAccNo();
            beneficiaryBankName= beneficiaryBeans.get(i).getBenBankName();
            beneficiaryBranchname= beneficiaryBeans.get(i).getBenBranchName();
            beneficiaryMobileNo= beneficiaryBeans.get(i).getMobileNumber();
            ifscCode=beneficiaryBeans.get(i).getIfsc_code();
            fatherName= beneficiaryBeans.get(i).getFatherName();
            motherName= beneficiaryBeans.get(i).getMotherName();

            if(!beneficiaryMobileNo.equalsIgnoreCase("NA"))
            {
                binding.edtMobile.setText(beneficiaryMobileNo);
                  binding.edtMobile.setFocusable(false);
            }

            binding.fatherName.setText(fatherName);
            binding.motherName.setText(motherName);




            // set Visibility
            binding.benAvaiVisi.setVisibility(View.VISIBLE);
            binding.mobVis.setVisibility(View.VISIBLE);
            binding.bankDetails.setVisibility(View.VISIBLE);
            binding.anyFamilyVisib.setVisibility(View.GONE);
            binding.nrlmVillVissib.setVisibility(View.GONE);
            binding.ngpVisib.setVisibility(View.GONE);
            binding.shgVisi.setVisibility(View.GONE);
            binding.fathervis.setVisibility(View.VISIBLE);
            binding.motherNamevis.setVisibility(View.VISIBLE);
            binding.memberVisi.setVisibility(View.GONE);
            binding.btnSave.setVisibility(View.GONE);
            binding.willingVisib.setVisibility(View.GONE);
            binding.reasonVisi.setVisibility(View.GONE);



            binding.spinnerBenAvail.setText("");
            binding.spinnerNrlmVillage.setText("");
            binding.spinnerNrlmGp.setText("");
            binding.spinnerInShg.setText("");
            binding.spinnerMemberName.setText("");
            binding.spinnerWilling.setText("");
            binding.spinnerReason.setText("");

            //-----Selected data set blank----

            selectedWIlling= "";
            selectedInShg= "";selectedBenAvailable= "";selectedReason= "";

            selectedNrlmGpCode= "";selectedNrlmGp= "";selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
            selectedShgCode= "";selectedmemberCode= "";selectedmember= "";




        });



//yes / No choice
        selectionFromAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_text,list );
        binding.spinnerBenAvail.setAdapter(selectionFromAdapter);
        selectionFromAdapter.notifyDataSetChanged();


//yes / No choice

        selectionFromAdapter1 = new ArrayAdapter<String>(getContext(), R.layout.spinner_text,list1 );
        binding.spinnerInShg.setAdapter(selectionFromAdapter1);
        selectionFromAdapter1.notifyDataSetChanged();


        // selection  Beneficiary Availability


        binding.spinnerBenAvail.setOnItemClickListener((adapterView, view1, i, l) -> {
            selectedBenAvailable= list.get(i);
            if (selectedBenAvailable.equalsIgnoreCase("Yes")) {


                // set Visibility
                binding.anyFamilyVisib.setVisibility(View.VISIBLE);
                binding.nrlmVillVissib.setVisibility(View.GONE);
                binding.ngpVisib.setVisibility(View.GONE);
                binding.shgVisi.setVisibility(View.GONE);
                binding.memberVisi.setVisibility(View.GONE);
                binding.btnSave.setVisibility(View.GONE);
                binding.willingVisib.setVisibility(View.GONE);
                binding.reasonVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

                selectedWIlling= "";
                selectedInShg= "";selectedReason= "";
                selectedNrlmGpCode= "";selectedNrlmGp= "";selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
                selectedShgCode= "";selectedmemberCode= "";selectedmember= "";


                binding.spinnerNrlmVillage.setText("");
                binding.spinnerNrlmGp.setText("");
                binding.spinnerInShg.setText("");
                binding.spinnerMemberName.setText("");
                binding.spinnerWilling.setText("");
                binding.spinnerReason.setText("");


            }
            else  if (selectedBenAvailable.equalsIgnoreCase("No")) {{

                binding.btnSave.setVisibility(View.VISIBLE);

                // set Visibility
                binding.anyFamilyVisib.setVisibility(View.GONE);
                binding.nrlmVillVissib.setVisibility(View.GONE);
                binding.ngpVisib.setVisibility(View.GONE);
                binding.shgVisi.setVisibility(View.GONE);
                binding.memberVisi.setVisibility(View.GONE);
                binding.willingVisib.setVisibility(View.GONE);
                binding.reasonVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

                selectedWIlling= "";
                selectedInShg= "";;selectedReason= "";
                selectedNrlmGpCode= "";selectedNrlmGp= "";selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
                selectedShgCode= "";selectedmemberCode= "";selectedmember= "";

                binding.spinnerNrlmVillage.setText("");
                binding.spinnerNrlmGp.setText("");
                binding.spinnerInShg.setText("");
                binding.spinnerMemberName.setText("");
                binding.spinnerWilling.setText("");
                binding.spinnerReason.setText("");

            }}
        });

        // select in SHG

        binding.spinnerInShg.setOnItemClickListener((adapterView, view1, i, l) -> {
            selectedInShg= list1.get(i);
            if (selectedInShg.equalsIgnoreCase("Yes (NRLM)")) {


                // set Visibility

                binding.nrlmVillVissib.setVisibility(View.VISIBLE);
                binding.ngpVisib.setVisibility(View.VISIBLE);
                binding.shgVisi.setVisibility(View.VISIBLE);
                binding.memberVisi.setVisibility(View.VISIBLE);
                binding.btnSave.setVisibility(View.GONE);
                binding.willingVisib.setVisibility(View.GONE);
                binding.reasonVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

                selectedWIlling= "";
                selectedReason= "";

                selectedNrlmGpCode= "";selectedNrlmGp= "";selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
                selectedShgCode= "";selectedmemberCode= "";selectedmember= "";

                binding.spinnerNrlmVillage.setText("");
                binding.spinnerNrlmGp.setText("");
                binding.spinnerMemberName.setText("");
                binding.spinnerWilling.setText("");
                binding.spinnerReason.setText("");
                binding.spinnerShgName.setText("");

            }
            else if (selectedInShg.equalsIgnoreCase("Yes (NON NRLM)")){



                // set Visibility
                binding.nrlmVillVissib.setVisibility(View.GONE);
                binding.ngpVisib.setVisibility(View.GONE);
                binding.shgVisi.setVisibility(View.GONE);
                binding.memberVisi.setVisibility(View.GONE);
                binding.btnSave.setVisibility(View.VISIBLE);
                binding.willingVisib.setVisibility(View.GONE);
                binding.reasonVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

                selectedWIlling= "";selectedReason= "";
                selectedNrlmGpCode= "";selectedNrlmGp= "";selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
                selectedShgCode= "";selectedmemberCode= "";selectedmember= "";



                binding.spinnerNrlmVillage.setText("");
                binding.spinnerShgName.setText("");
                binding.spinnerNrlmGp.setText("");
                binding.spinnerMemberName.setText("");
                binding.spinnerWilling.setText("");
                binding.spinnerReason.setText("");

            }
            else if (selectedInShg.equalsIgnoreCase("No")){



                // set Visibility

                binding.nrlmVillVissib.setVisibility(View.GONE);
                binding.ngpVisib.setVisibility(View.GONE);
                binding.shgVisi.setVisibility(View.GONE);
                binding.memberVisi.setVisibility(View.GONE);
                binding.btnSave.setVisibility(View.GONE);
                binding.willingVisib.setVisibility(View.VISIBLE);
                binding.reasonVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

                selectedWIlling= "";selectedReason= "";
                selectedNrlmGpCode= "";selectedNrlmGp= "";selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
                selectedShgCode= "";selectedmemberCode= "";selectedmember= "";

                binding.spinnerNrlmVillage.setText("");
                binding.spinnerShgName.setText("");
                binding.spinnerNrlmGp.setText("");
                binding.spinnerMemberName.setText("");
                binding.spinnerWilling.setText("");
                binding.spinnerReason.setText("");




            }

        });






        // button Save

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),selectedGp+selectedVillage+selectedBeneficiary+selectedWIlling
                        +selectedInShg+selectedBenAvailable+beneficiaryAccNo+beneficiaryId+selectedReason+
                        beneficiaryBankName+beneficiaryBranchname+beneficiaryMobileNo+ifscCode+
                        selectedNrlmGpCode+selectedNrlmGp+selectedNrlmVillageCode+selectedNrlmVillage+selectedShg+selectedShgCode+
                        selectedmemberCode+selectedmember,Toast.LENGTH_LONG).show();
            }
        });

        ///   selectNrlmGP


        nrlmGpAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_text,nrlmGpName );
        binding.spinnerNrlmGp.setAdapter(nrlmGpAdapter);
        nrlmGpAdapter.notifyDataSetChanged();


        binding.spinnerNrlmGp.setOnItemClickListener((adapterView, view1, i, l) -> {
            selectedNrlmGp= nrlmGpName.get(i);
            selectedNrlmGpCode= nrlmGpCode.get(i);

            nrlmVillageBeans = appDatabase.nrlmInfoDao().getNrlmVillage(selectedNrlmGpCode);
            nrlmVillageName = new ArrayList<String>();


            for (int j=0;j<nrlmVillageBeans.size();j++){
                nrlmVillageName.add(nrlmVillageBeans.get(j).getNrlmVillageName());
                //  Toast.makeText(getContext(), beneficiaryBeans.get(i).getBenName(), Toast.LENGTH_SHORT).show();

            }
            nrlmVillageAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_text,nrlmVillageName );
            binding.spinnerNrlmVillage.setAdapter(nrlmVillageAdapter);
            nrlmVillageAdapter.notifyDataSetChanged();

            if (!selectedNrlmGp.equalsIgnoreCase("")) {

                // set Visibility

                binding.nrlmVillVissib.setVisibility(View.VISIBLE);
                binding.shgVisi.setVisibility(View.VISIBLE);
                binding.memberVisi.setVisibility(View.VISIBLE);
                binding.btnSave.setVisibility(View.GONE);
                binding.willingVisib.setVisibility(View.GONE);
                binding.reasonVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

                selectedWIlling= "";
                selectedReason= "";

                selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
                selectedShgCode= "";selectedmemberCode= "";selectedmember= "";

                binding.spinnerNrlmVillage.setText("");
                binding.spinnerMemberName.setText("");
                binding.spinnerShgName.setText("");
                binding.spinnerWilling.setText("");
                binding.spinnerReason.setText("");

            }

        });


        //   selectNrlmVillage



        binding.spinnerNrlmVillage.setOnItemClickListener((adapterView, view1, i, l) -> {
            selectedNrlmVillage=   nrlmVillageName.get(i);
            //selectedNrlmVillageCode= nrlmVillageCode.get(i);


            shgBeans = appDatabase.nrlmInfoDao().getShg(selectedNrlmVillage);
            shgName = new ArrayList<String>();
            shgCode = new ArrayList<String>();

            for (int j=0;j<shgBeans.size();j++){
                shgName.add(shgBeans.get(j).getShgName());
                shgCode.add(shgBeans.get(j).getShgCode());
                //  Toast.makeText(getContext(),shgBeans.get(j).getShgName(), Toast.LENGTH_SHORT).show();

            }


            shgAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_text,shgName );
            binding.spinnerShgName.setAdapter(shgAdapter);
            shgAdapter.notifyDataSetChanged();
            if (!selectedNrlmVillage.equalsIgnoreCase("")) {


                // set Visibility

                binding.shgVisi.setVisibility(View.VISIBLE);
                binding.memberVisi.setVisibility(View.VISIBLE);
                binding.btnSave.setVisibility(View.GONE);
                binding.willingVisib.setVisibility(View.GONE);
                binding.reasonVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

                selectedWIlling= "";
                selectedReason= "";

                selectedShg= "";
                selectedShgCode= "";selectedmemberCode= "";selectedmember= "";


                binding.spinnerMemberName.setText("");
                binding.spinnerShgName.setText("");
                binding.spinnerWilling.setText("");
                binding.spinnerReason.setText("");
            }

        });


        ///   select Nrlm SHG



        binding.spinnerShgName.setOnItemClickListener((adapterView, view1, i, l) -> {
            selectedShg= shgName.get(i);
            selectedShgCode= shgCode.get(i);
            Toast.makeText(getContext(),selectedShgCode, Toast.LENGTH_SHORT).show();

            memberBeans = appDatabase.nrlmInfoDao().getMember(selectedShgCode);
           // Toast.makeText(getContext(),memberBeans.get(i).getMemberName(), Toast.LENGTH_SHORT).show();
            memberName = new ArrayList<String>();
            memberCode = new ArrayList<String>();
            for (int j=0;j<memberBeans.size();j++){
                memberName.add(memberBeans.get(j).getMemberName());
                memberCode.add(memberBeans.get(j).getMemberName());
             //   Toast.makeText(getContext(),shgBeans.get(j).getShgName(), Toast.LENGTH_SHORT).show();

            }

            memberAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_text,memberName );
            binding.spinnerMemberName.setAdapter(memberAdapter);
            memberAdapter.notifyDataSetChanged();
            if (!selectedShg.equalsIgnoreCase("")) {



                // set Visibility

                binding.memberVisi.setVisibility(View.VISIBLE);
                binding.btnSave.setVisibility(View.GONE);
                binding.willingVisib.setVisibility(View.GONE);
                binding.reasonVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

                selectedWIlling= "";
                selectedReason= "";

                selectedmemberCode= "";selectedmember= "";
                binding.spinnerMemberName.setText("");
                binding.spinnerWilling.setText("");
                binding.spinnerReason.setText("");

            }

        });
      //  select member

        binding.spinnerMemberName.setOnItemClickListener((adapterView, view1, i, l) -> {
            selectedmember= memberName.get(i);
            selectedmemberCode= memberCode.get(i);
            if (!selectedmember.equalsIgnoreCase("")) {


                // set Visibility

                binding.memberVisi.setVisibility(View.VISIBLE);
                binding.btnSave.setVisibility(View.VISIBLE);
                binding.willingVisib.setVisibility(View.GONE);
                binding.reasonVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

                selectedWIlling= "";
                selectedReason= "";
                binding.spinnerWilling.setText("");
                binding.spinnerReason.setText("");


            }

        });



        // selection of willing


        wiilingAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_text,list );
        binding.spinnerWilling.setAdapter(wiilingAdapter);
        wiilingAdapter.notifyDataSetChanged();
        binding.spinnerWilling.setOnItemClickListener((adapterView, view1, i, l) -> {
            selectedWIlling= list.get(i);
            if (selectedWIlling.equalsIgnoreCase("Yes")) {

                //set visibility
                binding.btnSave.setVisibility(View.VISIBLE);
                binding.nrlmVillVissib.setVisibility(View.GONE);
                binding.ngpVisib.setVisibility(View.GONE);
                binding.shgVisi.setVisibility(View.GONE);
                binding.memberVisi.setVisibility(View.GONE);
                binding.reasonVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

                selectedReason= "";

                selectedNrlmGpCode= "";selectedNrlmGp= "";selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
                selectedShgCode= "";selectedmemberCode= "";selectedmember= "";

                binding.spinnerNrlmVillage.setText("");
                binding.spinnerShgName.setText("");
                binding.spinnerNrlmGp.setText("");
                binding.spinnerMemberName.setText("");
                binding.spinnerReason.setText("");



            }
            else if(selectedWIlling.equalsIgnoreCase("No")) {

                //set visibility
                binding.nrlmVillVissib.setVisibility(View.GONE);
                binding.ngpVisib.setVisibility(View.GONE);
                binding.shgVisi.setVisibility(View.GONE);
                binding.btnSave.setVisibility(View.GONE);
                binding.reasonVisi.setVisibility(View.VISIBLE);
                binding.memberVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

                selectedReason= "";
                selectedNrlmGpCode= "";selectedNrlmGp= "";selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
                selectedShgCode= "";selectedmemberCode= "";selectedmember= "";

                binding.spinnerNrlmVillage.setText("");
                binding.spinnerShgName.setText("");
                binding.spinnerNrlmGp.setText("");
                binding.spinnerMemberName.setText("");
                binding.spinnerReason.setText("");


            }
        });

        ///   Reason


        reasonAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_text,reasonList );
        binding.spinnerReason.setAdapter(reasonAdapter);
        reasonAdapter.notifyDataSetChanged();
        binding.spinnerReason.setOnItemClickListener((adapterView, view1, i, l) -> {
            selectedReason= reasonList.get(i);
            if (!selectedReason.equalsIgnoreCase("")) {


                //set visibility
                binding.nrlmVillVissib.setVisibility(View.GONE);
                binding.ngpVisib.setVisibility(View.GONE);
                binding.shgVisi.setVisibility(View.GONE);
                binding.btnSave.setVisibility(View.VISIBLE);
                binding.memberVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----


                selectedNrlmGpCode= "";selectedNrlmGp= "";selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
                selectedShgCode= "";selectedmemberCode= "";selectedmember= "";



                binding.spinnerNrlmVillage.setText("");
                binding.spinnerShgName.setText("");
                binding.spinnerNrlmGp.setText("");
                binding.spinnerMemberName.setText("");

            }

        });






        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),selectedGp+selectedVillage+selectedBeneficiary+selectedWIlling
                        +selectedInShg+selectedBenAvailable+beneficiaryAccNo+beneficiaryId+selectedReason+
                        beneficiaryBankName+beneficiaryBranchname+beneficiaryMobileNo+ifscCode+
                        selectedNrlmGpCode+selectedNrlmGp+selectedNrlmVillageCode+selectedNrlmVillage+selectedShg+selectedShgCode+
                        selectedmemberCode+selectedmember,Toast.LENGTH_LONG).show();
            }
        });







        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.llBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBankDialog();
            }
        });





        /// Back Button Click

        binding.backclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFactory.getInstance().showAlertDialog(getContext(), 1, "Info"
                        , "Logout App", "Yes",
                        (dialog, which) -> logout(),
                        "Cancel", (dialog, which) -> {
                            dialog.dismiss();
                        },false);
                return;

            }
        });
       /* //GET Nrlm GP NAME

        List<NrlmDataBean> nrlmDataBeans = appDatabase.nrlmInfoDao().getNrlmList();
        nrlmGpName= new ArrayList<String>();
        nrlmGpCode= new ArrayList<String>();
        nrlmVillageName= new ArrayList<String>();
        nrlmVillageCode= new ArrayList<String>();
        shgName= new ArrayList<String>();
        shgCode= new ArrayList<String>();
        memberName= new ArrayList<String>();
        memberCode= new ArrayList<String>();
        reasonList= new ArrayList<String>();

        for (int i=0;i<nrlmDataBeans.size();i++){
            nrlmGpName.add(nrlmDataBeans.get(i).getGpName());
            nrlmGpCode.add(nrlmDataBeans.get(i).getGpCode());
            nrlmVillageName.add(nrlmDataBeans.get(i).getVillageName());
            nrlmVillageCode.add(nrlmDataBeans.get(i).getVillageCode());
            shgName.add(nrlmDataBeans.get(i).getShgName());
            shgCode.add(nrlmDataBeans.get(i).getShgCode());
            memberName.add(nrlmDataBeans.get(i).getMemberName());
            memberCode.add(nrlmDataBeans.get(i).getMemberCode());
            reasonList.add(nrlmDataBeans.get(i).getReason());

        }
*/


   /*

//yes / No choice
        selectionFromAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_text,list );
        binding.spinnerBenAvail.setAdapter(selectionFromAdapter);
        selectionFromAdapter.notifyDataSetChanged();


//yes / No choice

        selectionFromAdapter1 = new ArrayAdapter<String>(getContext(), R.layout.spinner_text,list1 );
        binding.spinnerInShg.setAdapter(selectionFromAdapter1);
        selectionFromAdapter1.notifyDataSetChanged();


        //Beneficiary selection


        beneficiaryAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_text,beneficiaryName );
        binding.spinnerBeneficiary.setAdapter(beneficiaryAdapter);
        beneficiaryAdapter.notifyDataSetChanged();

        binding.spinnerBeneficiary.setOnItemClickListener((adapterView, view1, i, l) -> {
            selectedBeneficiary= beneficiaryName.get(i);
            beneficiaryId= beneficiaryBeans.get(i).getBenId();
            beneficiaryAccNo= beneficiaryBeans.get(i).getBenAccNo();
            beneficiaryBankName= beneficiaryBeans.get(i).getBenBankName();
            beneficiaryBranchname= beneficiaryBeans.get(i).getBenBranchName();
            beneficiaryMobileNo= beneficiaryBeans.get(i).getMobileNumber();

            binding.edtMobile.setText(beneficiaryMobileNo);




            // set Visibility
            binding.benAvaiVisi.setVisibility(View.VISIBLE);
            binding.mobVis.setVisibility(View.VISIBLE);
            binding.bankDetails.setVisibility(View.VISIBLE);
            binding.anyFamilyVisib.setVisibility(View.GONE);
            binding.nrlmVillVissib.setVisibility(View.GONE);
            binding.ngpVisib.setVisibility(View.GONE);
            binding.shgVisi.setVisibility(View.GONE);
            binding.memberVisi.setVisibility(View.GONE);
            binding.btnSave.setVisibility(View.GONE);
            binding.willingVisib.setVisibility(View.GONE);
            binding.reasonVisi.setVisibility(View.GONE);



            binding.spinnerBenAvail.setText("");
            binding.spinnerNrlmVillage.setText("");
            binding.spinnerNrlmGp.setText("");
            binding.spinnerInShg.setText("");
            binding.spinnerMemberName.setText("");
            binding.spinnerWilling.setText("");
            binding.spinnerReason.setText("");

            //-----Selected data set blank----

            selectedWIlling= "";
            selectedInShg= "";selectedBenAvailable= "";selectedReason= "";

            selectedNrlmGpCode= "";selectedNrlmGp= "";selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
            selectedShgCode= "";selectedmemberCode= "";selectedmember= "";




        });


        // selection  Beneficiary Availability


        binding.spinnerBenAvail.setOnItemClickListener((adapterView, view1, i, l) -> {
            selectedBenAvailable= list.get(i);
            if (selectedBenAvailable.equalsIgnoreCase("Yes")) {


                // set Visibility
                binding.anyFamilyVisib.setVisibility(View.VISIBLE);
                binding.nrlmVillVissib.setVisibility(View.GONE);
                binding.ngpVisib.setVisibility(View.GONE);
                binding.shgVisi.setVisibility(View.GONE);
                binding.memberVisi.setVisibility(View.GONE);
                binding.btnSave.setVisibility(View.GONE);
                binding.willingVisib.setVisibility(View.GONE);
                binding.reasonVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

                selectedWIlling= "";
                selectedInShg= "";selectedReason= "";
                selectedNrlmGpCode= "";selectedNrlmGp= "";selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
                selectedShgCode= "";selectedmemberCode= "";selectedmember= "";


                binding.spinnerNrlmVillage.setText("");
                binding.spinnerNrlmGp.setText("");
                binding.spinnerInShg.setText("");
                binding.spinnerMemberName.setText("");
                binding.spinnerWilling.setText("");
                binding.spinnerReason.setText("");


            }
            else  if (selectedBenAvailable.equalsIgnoreCase("No")) {{

                binding.btnSave.setVisibility(View.VISIBLE);

                // set Visibility
                binding.anyFamilyVisib.setVisibility(View.GONE);
                binding.nrlmVillVissib.setVisibility(View.GONE);
                binding.ngpVisib.setVisibility(View.GONE);
                binding.shgVisi.setVisibility(View.GONE);
                binding.memberVisi.setVisibility(View.GONE);
                binding.willingVisib.setVisibility(View.GONE);
                binding.reasonVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

                selectedWIlling= "";
                selectedInShg= "";;selectedReason= "";
                selectedNrlmGpCode= "";selectedNrlmGp= "";selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
                selectedShgCode= "";selectedmemberCode= "";selectedmember= "";

                binding.spinnerNrlmVillage.setText("");
                binding.spinnerNrlmGp.setText("");
                binding.spinnerInShg.setText("");
                binding.spinnerMemberName.setText("");
                binding.spinnerWilling.setText("");
                binding.spinnerReason.setText("");

            }}
        });

           // select in SHG

        binding.spinnerInShg.setOnItemClickListener((adapterView, view1, i, l) -> {
            selectedInShg= list1.get(i);
            if (selectedInShg.equalsIgnoreCase("Yes (NRLM)")) {


                // set Visibility

                binding.nrlmVillVissib.setVisibility(View.VISIBLE);
                binding.ngpVisib.setVisibility(View.VISIBLE);
                binding.shgVisi.setVisibility(View.VISIBLE);
                binding.memberVisi.setVisibility(View.VISIBLE);
                binding.btnSave.setVisibility(View.GONE);
                binding.willingVisib.setVisibility(View.GONE);
                binding.reasonVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

                selectedWIlling= "";
              selectedReason= "";

                selectedNrlmGpCode= "";selectedNrlmGp= "";selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
                selectedShgCode= "";selectedmemberCode= "";selectedmember= "";

                binding.spinnerNrlmVillage.setText("");
                binding.spinnerNrlmGp.setText("");
                binding.spinnerMemberName.setText("");
                binding.spinnerWilling.setText("");
                binding.spinnerReason.setText("");
                binding.spinnerShgName.setText("");

            }
            else if (selectedInShg.equalsIgnoreCase("Yes (NON NRLM)")){



                // set Visibility
                binding.nrlmVillVissib.setVisibility(View.GONE);
                binding.ngpVisib.setVisibility(View.GONE);
                binding.shgVisi.setVisibility(View.GONE);
                binding.memberVisi.setVisibility(View.GONE);
                binding.btnSave.setVisibility(View.VISIBLE);
                binding.willingVisib.setVisibility(View.GONE);
                binding.reasonVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

                selectedWIlling= "";selectedReason= "";
                selectedNrlmGpCode= "";selectedNrlmGp= "";selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
                selectedShgCode= "";selectedmemberCode= "";selectedmember= "";



                binding.spinnerNrlmVillage.setText("");
                binding.spinnerShgName.setText("");
                binding.spinnerNrlmGp.setText("");
                binding.spinnerMemberName.setText("");
                binding.spinnerWilling.setText("");
                binding.spinnerReason.setText("");

            }
            else if (selectedInShg.equalsIgnoreCase("No")){



                // set Visibility

                binding.nrlmVillVissib.setVisibility(View.GONE);
                binding.ngpVisib.setVisibility(View.GONE);
                binding.shgVisi.setVisibility(View.GONE);
                binding.memberVisi.setVisibility(View.GONE);
                binding.btnSave.setVisibility(View.GONE);
                binding.willingVisib.setVisibility(View.VISIBLE);
                binding.reasonVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

                selectedWIlling= "";selectedReason= "";
                selectedNrlmGpCode= "";selectedNrlmGp= "";selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
                selectedShgCode= "";selectedmemberCode= "";selectedmember= "";

                binding.spinnerNrlmVillage.setText("");
                binding.spinnerShgName.setText("");
                binding.spinnerNrlmGp.setText("");
                binding.spinnerMemberName.setText("");
                binding.spinnerWilling.setText("");
                binding.spinnerReason.setText("");




            }

        });

    // selection of willing


        wiilingAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_text,list );
        binding.spinnerWilling.setAdapter(wiilingAdapter);
        wiilingAdapter.notifyDataSetChanged();
        binding.spinnerWilling.setOnItemClickListener((adapterView, view1, i, l) -> {
            selectedWIlling= list.get(i);
            if (selectedWIlling.equalsIgnoreCase("Yes")) {

                //set visibility
                binding.btnSave.setVisibility(View.VISIBLE);
                binding.nrlmVillVissib.setVisibility(View.GONE);
                binding.ngpVisib.setVisibility(View.GONE);
                binding.shgVisi.setVisibility(View.GONE);
                binding.memberVisi.setVisibility(View.GONE);
                binding.reasonVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

            selectedReason= "";

                selectedNrlmGpCode= "";selectedNrlmGp= "";selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
                selectedShgCode= "";selectedmemberCode= "";selectedmember= "";

                binding.spinnerNrlmVillage.setText("");
                binding.spinnerShgName.setText("");
                binding.spinnerNrlmGp.setText("");
                binding.spinnerMemberName.setText("");
                binding.spinnerReason.setText("");



            }
            else if(selectedWIlling.equalsIgnoreCase("No")) {

                //set visibility
                binding.nrlmVillVissib.setVisibility(View.GONE);
                binding.ngpVisib.setVisibility(View.GONE);
                binding.shgVisi.setVisibility(View.GONE);
                binding.btnSave.setVisibility(View.GONE);
                binding.reasonVisi.setVisibility(View.VISIBLE);
                binding.memberVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

                selectedReason= "";
                selectedNrlmGpCode= "";selectedNrlmGp= "";selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
                selectedShgCode= "";selectedmemberCode= "";selectedmember= "";

                binding.spinnerNrlmVillage.setText("");
                binding.spinnerShgName.setText("");
                binding.spinnerNrlmGp.setText("");
                binding.spinnerMemberName.setText("");
                binding.spinnerReason.setText("");


            }
        });

 ///   Reason


        reasonAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_text,reasonList );
        binding.spinnerReason.setAdapter(reasonAdapter);
        reasonAdapter.notifyDataSetChanged();
        binding.spinnerReason.setOnItemClickListener((adapterView, view1, i, l) -> {
            selectedReason= reasonList.get(i);
            if (!selectedReason.equalsIgnoreCase("")) {


                //set visibility
                binding.nrlmVillVissib.setVisibility(View.GONE);
                binding.ngpVisib.setVisibility(View.GONE);
                binding.shgVisi.setVisibility(View.GONE);
                binding.btnSave.setVisibility(View.VISIBLE);
                binding.memberVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----


                selectedNrlmGpCode= "";selectedNrlmGp= "";selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
                selectedShgCode= "";selectedmemberCode= "";selectedmember= "";



                binding.spinnerNrlmVillage.setText("");
                binding.spinnerShgName.setText("");
                binding.spinnerNrlmGp.setText("");
                binding.spinnerMemberName.setText("");

            }

        });


        ///   selectNrlmGP


        nrlmGpAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_text,nrlmGpName );
        binding.spinnerNrlmGp.setAdapter(nrlmGpAdapter);
        nrlmGpAdapter.notifyDataSetChanged();
        binding.spinnerNrlmGp.setOnItemClickListener((adapterView, view1, i, l) -> {
            selectedNrlmGp= nrlmGpName.get(i);
            selectedNrlmGpCode= nrlmGpCode.get(i);
            if (!selectedNrlmGp.equalsIgnoreCase("")) {

                // set Visibility

                binding.nrlmVillVissib.setVisibility(View.VISIBLE);
                binding.shgVisi.setVisibility(View.VISIBLE);
                binding.memberVisi.setVisibility(View.VISIBLE);
                binding.btnSave.setVisibility(View.GONE);
                binding.willingVisib.setVisibility(View.GONE);
                binding.reasonVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

                selectedWIlling= "";
                selectedReason= "";

               selectedNrlmVillageCode= "";selectedNrlmVillage= "";selectedShg= "";
                selectedShgCode= "";selectedmemberCode= "";selectedmember= "";

                binding.spinnerNrlmVillage.setText("");
                binding.spinnerMemberName.setText("");
                binding.spinnerShgName.setText("");
                binding.spinnerWilling.setText("");
                binding.spinnerReason.setText("");

            }

        });

        ///   selectNrlmVillage


        nrlmVillageAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_text,nrlmVillageName );
        binding.spinnerNrlmVillage.setAdapter(nrlmVillageAdapter);
        nrlmVillageAdapter.notifyDataSetChanged();
        binding.spinnerNrlmVillage.setOnItemClickListener((adapterView, view1, i, l) -> {
            selectedNrlmVillage= nrlmGpName.get(i);
            selectedNrlmVillageCode= nrlmVillageCode.get(i);
            if (!selectedNrlmVillage.equalsIgnoreCase("")) {


                // set Visibility

                binding.shgVisi.setVisibility(View.VISIBLE);
                binding.memberVisi.setVisibility(View.VISIBLE);
                binding.btnSave.setVisibility(View.GONE);
                binding.willingVisib.setVisibility(View.GONE);
                binding.reasonVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

                selectedWIlling= "";
                selectedReason= "";

                selectedShg= "";
                selectedShgCode= "";selectedmemberCode= "";selectedmember= "";


                binding.spinnerMemberName.setText("");
                binding.spinnerShgName.setText("");
                binding.spinnerWilling.setText("");
                binding.spinnerReason.setText("");
            }

        });

        ///   select Nrlm SHG


        shgAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_text,shgName );
        binding.spinnerShgName.setAdapter(shgAdapter);
        shgAdapter.notifyDataSetChanged();
        binding.spinnerShgName.setOnItemClickListener((adapterView, view1, i, l) -> {
            selectedShg= shgName.get(i);
            selectedShgCode= shgCode.get(i);
            if (!selectedShg.equalsIgnoreCase("")) {



                // set Visibility

                binding.memberVisi.setVisibility(View.VISIBLE);
                binding.btnSave.setVisibility(View.GONE);
                binding.willingVisib.setVisibility(View.GONE);
                binding.reasonVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

                selectedWIlling= "";
                selectedReason= "";

               selectedmemberCode= "";selectedmember= "";
                binding.spinnerMemberName.setText("");
                binding.spinnerWilling.setText("");
                binding.spinnerReason.setText("");

            }

        });

        ///   select Nrlm Member


        memberAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_text,memberName );
        binding.spinnerMemberName.setAdapter(memberAdapter);
        memberAdapter.notifyDataSetChanged();
        binding.spinnerMemberName.setOnItemClickListener((adapterView, view1, i, l) -> {
            selectedmember= memberName.get(i);
            selectedmemberCode= memberCode.get(i);
            if (!selectedmember.equalsIgnoreCase("")) {


                // set Visibility

                binding.memberVisi.setVisibility(View.VISIBLE);
                binding.btnSave.setVisibility(View.VISIBLE);
                binding.willingVisib.setVisibility(View.GONE);
                binding.reasonVisi.setVisibility(View.GONE);

                //-----Seleted data set blank----

                selectedWIlling= "";
                selectedReason= "";
                binding.spinnerWilling.setText("");
                binding.spinnerReason.setText("");


            }

        });


        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),selectedGp+selectedVillage+selectedBeneficiary+selectedWIlling
                                +selectedInShg+selectedBenAvailable+beneficiaryAccNo+beneficiaryId+selectedReason+
                        beneficiaryBankName+beneficiaryBranchname+beneficiaryMobileNo+
                        selectedNrlmGpCode+selectedNrlmGp+selectedNrlmVillageCode+selectedNrlmVillage+selectedShg+selectedShgCode+
                        selectedmemberCode+selectedmember,Toast.LENGTH_LONG).show();
            }
        });*/

    }

    private void showBankDialog(){
        final Dialog dialog = new Dialog(getContext());
        DialogBankDetailsBinding bankDialogBinding=DialogBankDetailsBinding.inflate(getLayoutInflater());
        dialog.setContentView(bankDialogBinding.getRoot());
        bankDialogBinding.tvAcc.setText("Account Number : "+beneficiaryAccNo);
        bankDialogBinding.tvBankName.setText("Bank Name : "+beneficiaryBankName);
        bankDialogBinding.tvBranchName.setText("Branch Name : "+beneficiaryBranchname);
       bankDialogBinding.ifsc.setText("IFSC Code : "+ifscCode); //manish comment
        bankDialogBinding.tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
    }
    public void exit(){
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
    public void logout(){
        navController = NavHostFragment.findNavController(this);

        NavDirections navDirections= HomeFragmentDirections.actionHomeFragmentToLoginFragment();
        navController.navigate(navDirections);
    }

    public void changeLanguage()
    {
        navController = NavHostFragment.findNavController(this);
        NavDirections navDirections=HomeFragmentDirections.actionHomeFragmentToChangeLanguageFragment();
        navController.navigate(navDirections);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        menu.clear();

        inflater.inflate(R.menu.menu, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.logOut:
                Toast.makeText(getContext(), "Working", Toast.LENGTH_SHORT).show();
                logout();

                // Not implemented here
                return true;
            case R.id.changeLanguage:
                changeLanguage();

                return true;

            default:
                break;
        }

        return false;
    }
}