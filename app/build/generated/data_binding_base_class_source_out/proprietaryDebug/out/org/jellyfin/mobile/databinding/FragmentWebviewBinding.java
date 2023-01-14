// Generated by view binder compiler. Do not edit!
package org.jellyfin.mobile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import org.jellyfin.mobile.R;

public final class FragmentWebviewBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final ConstraintLayout loadingContainer;

  @NonNull
  public final CircularProgressIndicator progressIndicator;

  @NonNull
  public final Button useDifferentServerButton;

  @NonNull
  public final WebView webView;

  private FragmentWebviewBinding(@NonNull CoordinatorLayout rootView,
      @NonNull ConstraintLayout loadingContainer,
      @NonNull CircularProgressIndicator progressIndicator,
      @NonNull Button useDifferentServerButton, @NonNull WebView webView) {
    this.rootView = rootView;
    this.loadingContainer = loadingContainer;
    this.progressIndicator = progressIndicator;
    this.useDifferentServerButton = useDifferentServerButton;
    this.webView = webView;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentWebviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentWebviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_webview, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentWebviewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.loading_container;
      ConstraintLayout loadingContainer = ViewBindings.findChildViewById(rootView, id);
      if (loadingContainer == null) {
        break missingId;
      }

      id = R.id.progress_indicator;
      CircularProgressIndicator progressIndicator = ViewBindings.findChildViewById(rootView, id);
      if (progressIndicator == null) {
        break missingId;
      }

      id = R.id.use_different_server_button;
      Button useDifferentServerButton = ViewBindings.findChildViewById(rootView, id);
      if (useDifferentServerButton == null) {
        break missingId;
      }

      id = R.id.web_view;
      WebView webView = ViewBindings.findChildViewById(rootView, id);
      if (webView == null) {
        break missingId;
      }

      return new FragmentWebviewBinding((CoordinatorLayout) rootView, loadingContainer,
          progressIndicator, useDifferentServerButton, webView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}