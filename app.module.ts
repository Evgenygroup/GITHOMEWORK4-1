import { BrowserModule } from '@angular/platform-browser';

import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserRegistrationComponent } from './components/user-registration/user-registration.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { PasswordModule } from 'primeng/password';
import { ValidationErrorsComponent } from './components/validation-errors/validation-errors.component';
import { LanguageSwitcherComponent } from './components/language-switcher/language-switcher.component';
import { TransDirective } from './directives/trans.directive';
import { DummyComponent } from './components/dummy/dummy.component';
import { RevDirective } from './directives/rev/rev.directive';

@NgModule({
  declarations: [
    AppComponent,
    UserRegistrationComponent,
    ValidationErrorsComponent,
    LanguageSwitcherComponent,
    TransDirective,
    DummyComponent,
    RevDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    PasswordModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
