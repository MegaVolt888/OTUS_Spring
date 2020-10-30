import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthorRoutingModule } from './author-routing.module';
import { AuthorComponent } from './author.component';
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [AuthorComponent],
  imports: [
    CommonModule,
    FormsModule,
    AuthorRoutingModule
  ]
})
export class AuthorModule { }
