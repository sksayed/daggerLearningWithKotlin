package com.example.daggerlearning.di.module

import com.example.daggerlearning.data.pkg.model.EnglishUser
import com.example.daggerlearning.data.pkg.model.Person
import com.example.daggerlearning.data.pkg.model.SpanishUser
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class PersonModule {

    @EnglishUserQualifier
    @Binds
    abstract fun bindEnglishUserImpl(englishUser: EnglishUser):Person

    @SpanishUserQualifier
    @Binds
    abstract fun bindSpanishUserImpl (spanishUser: SpanishUser):Person
}

@Qualifier
annotation class EnglishUserQualifier

@Qualifier
annotation class SpanishUserQualifier