import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

const appRoutes: Routes = [
  {
    path: '',
    loadChildren: './welcome/welcome.module#WelcomeModule'
  },
  {
    path: 'list',
    loadChildren: './list/list.module#ListModule'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
