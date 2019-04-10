import {Component, OnInit} from '@angular/core';
import {TaskItem} from './task-item.type';
import {TodosService} from './todos.service';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html'
})
export class ListComponent implements OnInit {

  private data: TaskItem[];

  constructor(private todoService: TodosService,
              private http: HttpClient) {
  }

  get items(): TaskItem[] {
    return this.data;
  }

  ngOnInit(): void {
    this.todoService.getTodos()
      .subscribe(data => {
        data.forEach(item => {
          item.createdDate = new Date();
        });
        this.data = data;
      });
  }

  callCreate(): void {
    const fakeData = this.data[0];
    this.http.post<void>('/fakeUrl', fakeData)
      .subscribe(() => {});
  }
}
