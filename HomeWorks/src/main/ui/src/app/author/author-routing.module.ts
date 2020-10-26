import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {AuthorComponent} from './author.component';

const routes: Routes = [
  {path: 'authors', component: AuthorComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthorRoutingModule {
}
