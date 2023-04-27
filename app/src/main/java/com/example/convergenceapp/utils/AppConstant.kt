package com.example.convergenceapp.utils;
class AppConstant {
    companion object ConstantObject {
        const val wantToShow: Boolean = true
        const val dummyImei: String = "dummy_123456789"
        const val noInternetCode: String = "12163"
        const val unsyncStatus: String = "0"
        const val syncStatus: String = "1"
        const val beforeNrlmStatus: String = "B"
        const val entryCompleted: String = "1"
        const val entryNotCompleted: String = "0"
        const val afterNrlmStatus: String = "A"
        const val geoSelection: String = "gp_village"
        const val vo_clfSelection: String = "vo_clf"
        const val nrlm_formation_date: String = "01-06-2011"
        const val st = "securityToken"

        const val s= "n{j5Y[<!Ps*HWCWg"
        val items = arrayOf("Income (Before coming into NRLM Fold)", "Income at present")
        val confirmation = arrayOf("Do you confirm all this entry", "Do You want still add more activity")
        val selectYN = arrayOf("Yes","No");
        val selectYyN = arrayOf("Yes (NRLM)","Yes (Non NRLM)","No");
            const val baseUrl: String = "http://10.197.183.105:8080/nrlmwebservice/services/convergence/"    //local
          //  const val baseUrl: String = "https://nrlm.gov.in/lakhpatidemo/lakhpatiakhpatishg/"    //demo
     //  const val baseUrl: String = "http://10.197.183.105:8989/lakhpatishg/"          //local


    }
}

//using minimum build version N because for data base operation using Stream API......