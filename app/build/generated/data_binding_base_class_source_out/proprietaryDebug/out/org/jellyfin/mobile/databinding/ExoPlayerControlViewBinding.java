// Generated by view binder compiler. Do not edit!
package org.jellyfin.mobile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import org.jellyfin.mobile.R;

public final class ExoPlayerControlViewBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AppCompatImageButton audioStreamsButton;

  @NonNull
  public final Barrier controlsBarrier;

  @NonNull
  public final AppCompatImageButton decoderButton;

  @NonNull
  public final AppCompatTextView exoDuration;

  @NonNull
  public final AppCompatImageButton exoPause;

  @NonNull
  public final AppCompatImageButton exoPlay;

  @NonNull
  public final AppCompatTextView exoPosition;

  @NonNull
  public final DefaultTimeBar exoProgress;

  @NonNull
  public final AppCompatImageButton fullscreenSwitcher;

  @NonNull
  public final AppCompatImageButton infoButton;

  @NonNull
  public final AppCompatImageButton lockScreenButton;

  @NonNull
  public final AppCompatImageButton nextButton;

  @NonNull
  public final FrameLayout playPauseContainer;

  @NonNull
  public final ConstraintLayout playerControls;

  @NonNull
  public final AppCompatImageButton previousButton;

  @NonNull
  public final AppCompatImageButton qualityButton;

  @NonNull
  public final AppCompatImageButton speedButton;

  @NonNull
  public final AppCompatImageButton subtitlesButton;

  @NonNull
  public final Toolbar toolbar;

  private ExoPlayerControlViewBinding(@NonNull ConstraintLayout rootView,
      @NonNull AppCompatImageButton audioStreamsButton, @NonNull Barrier controlsBarrier,
      @NonNull AppCompatImageButton decoderButton, @NonNull AppCompatTextView exoDuration,
      @NonNull AppCompatImageButton exoPause, @NonNull AppCompatImageButton exoPlay,
      @NonNull AppCompatTextView exoPosition, @NonNull DefaultTimeBar exoProgress,
      @NonNull AppCompatImageButton fullscreenSwitcher, @NonNull AppCompatImageButton infoButton,
      @NonNull AppCompatImageButton lockScreenButton, @NonNull AppCompatImageButton nextButton,
      @NonNull FrameLayout playPauseContainer, @NonNull ConstraintLayout playerControls,
      @NonNull AppCompatImageButton previousButton, @NonNull AppCompatImageButton qualityButton,
      @NonNull AppCompatImageButton speedButton, @NonNull AppCompatImageButton subtitlesButton,
      @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.audioStreamsButton = audioStreamsButton;
    this.controlsBarrier = controlsBarrier;
    this.decoderButton = decoderButton;
    this.exoDuration = exoDuration;
    this.exoPause = exoPause;
    this.exoPlay = exoPlay;
    this.exoPosition = exoPosition;
    this.exoProgress = exoProgress;
    this.fullscreenSwitcher = fullscreenSwitcher;
    this.infoButton = infoButton;
    this.lockScreenButton = lockScreenButton;
    this.nextButton = nextButton;
    this.playPauseContainer = playPauseContainer;
    this.playerControls = playerControls;
    this.previousButton = previousButton;
    this.qualityButton = qualityButton;
    this.speedButton = speedButton;
    this.subtitlesButton = subtitlesButton;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ExoPlayerControlViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ExoPlayerControlViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.exo_player_control_view, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ExoPlayerControlViewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.audio_streams_button;
      AppCompatImageButton audioStreamsButton = ViewBindings.findChildViewById(rootView, id);
      if (audioStreamsButton == null) {
        break missingId;
      }

      id = R.id.controls_barrier;
      Barrier controlsBarrier = ViewBindings.findChildViewById(rootView, id);
      if (controlsBarrier == null) {
        break missingId;
      }

      id = R.id.decoder_button;
      AppCompatImageButton decoderButton = ViewBindings.findChildViewById(rootView, id);
      if (decoderButton == null) {
        break missingId;
      }

      id = R.id.exo_duration;
      AppCompatTextView exoDuration = ViewBindings.findChildViewById(rootView, id);
      if (exoDuration == null) {
        break missingId;
      }

      id = R.id.exo_pause;
      AppCompatImageButton exoPause = ViewBindings.findChildViewById(rootView, id);
      if (exoPause == null) {
        break missingId;
      }

      id = R.id.exo_play;
      AppCompatImageButton exoPlay = ViewBindings.findChildViewById(rootView, id);
      if (exoPlay == null) {
        break missingId;
      }

      id = R.id.exo_position;
      AppCompatTextView exoPosition = ViewBindings.findChildViewById(rootView, id);
      if (exoPosition == null) {
        break missingId;
      }

      id = R.id.exo_progress;
      DefaultTimeBar exoProgress = ViewBindings.findChildViewById(rootView, id);
      if (exoProgress == null) {
        break missingId;
      }

      id = R.id.fullscreen_switcher;
      AppCompatImageButton fullscreenSwitcher = ViewBindings.findChildViewById(rootView, id);
      if (fullscreenSwitcher == null) {
        break missingId;
      }

      id = R.id.info_button;
      AppCompatImageButton infoButton = ViewBindings.findChildViewById(rootView, id);
      if (infoButton == null) {
        break missingId;
      }

      id = R.id.lock_screen_button;
      AppCompatImageButton lockScreenButton = ViewBindings.findChildViewById(rootView, id);
      if (lockScreenButton == null) {
        break missingId;
      }

      id = R.id.next_button;
      AppCompatImageButton nextButton = ViewBindings.findChildViewById(rootView, id);
      if (nextButton == null) {
        break missingId;
      }

      id = R.id.play_pause_container;
      FrameLayout playPauseContainer = ViewBindings.findChildViewById(rootView, id);
      if (playPauseContainer == null) {
        break missingId;
      }

      ConstraintLayout playerControls = (ConstraintLayout) rootView;

      id = R.id.previous_button;
      AppCompatImageButton previousButton = ViewBindings.findChildViewById(rootView, id);
      if (previousButton == null) {
        break missingId;
      }

      id = R.id.quality_button;
      AppCompatImageButton qualityButton = ViewBindings.findChildViewById(rootView, id);
      if (qualityButton == null) {
        break missingId;
      }

      id = R.id.speed_button;
      AppCompatImageButton speedButton = ViewBindings.findChildViewById(rootView, id);
      if (speedButton == null) {
        break missingId;
      }

      id = R.id.subtitles_button;
      AppCompatImageButton subtitlesButton = ViewBindings.findChildViewById(rootView, id);
      if (subtitlesButton == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new ExoPlayerControlViewBinding((ConstraintLayout) rootView, audioStreamsButton,
          controlsBarrier, decoderButton, exoDuration, exoPause, exoPlay, exoPosition, exoProgress,
          fullscreenSwitcher, infoButton, lockScreenButton, nextButton, playPauseContainer,
          playerControls, previousButton, qualityButton, speedButton, subtitlesButton, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}