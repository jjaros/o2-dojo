import { NgModule } from '@angular/core';

import {ListComponent} from './list.component';
import {ListRoutingModule} from './list-routing.module';
import {CommonModule} from '@angular/common';
import {HttpClientModule} from '@angular/common/http';
import {TodosService} from './todos.service';

@NgModule(
  {
    declarations: [
      ListComponent
    ],
    imports: [
      ListRoutingModule,
      CommonModule,
      HttpClientModule
    ],
    providers: [
      TodosService
    ]
  })
export class ListModule { }
