package com.example.convergenceapp.Auth;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.convergenceapp.R;

public class HomeFragmentDirections {
  private HomeFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionHomeFragmentToLoginFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_loginFragment);
  }

  @NonNull
  public static NavDirections actionHomeFragmentToChangeLanguageFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_changeLanguageFragment);
  }
}
