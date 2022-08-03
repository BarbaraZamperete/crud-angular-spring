import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, of } from 'rxjs';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

import { CoursesService } from '../services/courses.service';
import { Course } from './../model/course';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent implements OnInit {


  courses$: Observable<Course[]>
  displayedColumns = ['name', 'category', 'actions']

  constructor(
    private coursesService: CoursesService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.courses$ = this.coursesService.list()
      .pipe(
        catchError(_error => {
          this.onError('Erro ao carregar cursos.')
          return of([]) //cria um observable de array vazio
        })
      )
  }

  ngOnInit(): void {
    // TODO document why this method 'ngOnInit' is empty

  }


  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    })
  }

  onAdd(){
    console.log('onAdd')
    this.router.navigate(['new'], {relativeTo: this.route}) //go to courses/new
  }
}
