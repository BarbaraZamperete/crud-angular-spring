import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay, first, Observable, tap } from 'rxjs';

import { Course } from './../model/course';

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  private readonly API = '/assets/courses.json'
  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Course[]>(this.API).pipe(
      first(), //assim que recebe a resposta o serviço fecha e não fica ouvindo p sempre
      delay(2000),
      tap(course => console.log(course))
    )
  }
}
