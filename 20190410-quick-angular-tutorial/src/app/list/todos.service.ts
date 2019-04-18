import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {TaskItem} from './task-item.type';
import {Observable} from 'rxjs';

@Injectable()
export class TodosService {

  constructor(private http: HttpClient) {
  }

  getTodos(): Observable<TaskItem[]> {
    return this.http.get<TaskItem[]>('https://jsonplaceholder.typicode.com/todos');
  }

}
