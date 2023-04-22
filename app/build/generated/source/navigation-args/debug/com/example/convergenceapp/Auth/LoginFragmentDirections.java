package com.example.convergenceapp.Auth;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.convergenceapp.R;

public class LoginFragmentDirections {
  private LoginFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionLoginFragmentToHomeFragment() {
    return new ActionOnlyNavDirections(R.id.action_loginFragment_to_homeFragment);
  }
}
