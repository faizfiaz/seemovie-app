// Generated by Dagger (https://google.github.io/dagger).
package com.selfcompany.faizf.seemovie.presentation.activity;

import com.selfcompany.faizf.newbase.manager.DialogManager;
import com.selfcompany.faizf.seemovie.presentation.seemore.SeeMoreActivity;
import com.selfcompany.faizf.seemovie.presentation.seemore.SeeMorePres;

import dagger.MembersInjector;
import javax.inject.Provider;

public final class SeeMoreActivity_MembersInjector implements MembersInjector<SeeMoreActivity> {
  private final Provider<DialogManager> dialogManagerProvider;

  private final Provider<SeeMorePres> presenterProvider;

  public SeeMoreActivity_MembersInjector(
      Provider<DialogManager> dialogManagerProvider, Provider<SeeMorePres> presenterProvider) {
    this.dialogManagerProvider = dialogManagerProvider;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<SeeMoreActivity> create(
      Provider<DialogManager> dialogManagerProvider, Provider<SeeMorePres> presenterProvider) {
    return new SeeMoreActivity_MembersInjector(dialogManagerProvider, presenterProvider);
  }

  @Override
  public void injectMembers(SeeMoreActivity instance) {
    BaseActivity_MembersInjector.injectDialogManager(instance, dialogManagerProvider.get());
    injectPresenter(instance, presenterProvider.get());
  }

  public static void injectPresenter(SeeMoreActivity instance, SeeMorePres presenter) {
    instance.presenter = presenter;
  }
}