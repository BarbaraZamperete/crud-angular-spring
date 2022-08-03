import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

import { CoursesService } from './../services/courses.service';

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss']
})
export class CourseFormComponent implements OnInit {

  form: FormGroup //grupo de compos

  constructor(
    private formBuilder: FormBuilder,
    private service: CoursesService,
    private _snackBar: MatSnackBar,
    private location: Location
  ) {
    this.form = this.formBuilder.group({
      name: [null], //inicializa o campo sem valor
      category: [null]
    })
  }

  ngOnInit(): void {
    // TODO document why this method 'ngOnInit' is empty

  }

  onSubmit() {
    this.service.save(this.form.value)
      .subscribe(() => this.onSuccess(), () => this.onError())
  }

  onCancel() {
    this.location.back()
  }

  private onSuccess(){
    this._snackBar.open("Curso salvo com sucesso", '', {
      duration: 5000
    })
    this.onCancel()
  }

  private onError() {
    this._snackBar.open("Erro ao salvar curso", '', {
      duration: 5000
    })
  }
}
