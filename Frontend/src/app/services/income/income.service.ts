import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASIC_URL = "http://localhost:8080/"

@Injectable({
  providedIn: 'root'
})
export class IncomeService {

  constructor(private http: HttpClient) { }

  postIncome(incomeDTO: any): Observable<any> {
    return this.http.post(BASIC_URL + "api/income", incomeDTO);
  }

  getAllIncomes(): Observable<any> {
    return this.http.get(BASIC_URL + "api/income/all");
  }

  getIncomeById(id: Number): Observable<any> {
    return this.http.get(BASIC_URL + `api/income/${id}`);
  }

  updateIncome(id: Number, incomeDTO: any): Observable<any> {
    return this.http.put(BASIC_URL + `api/income/${id}`, incomeDTO);
  }

  deleteIncome(id: Number): Observable<any> {
    return this.http.delete(BASIC_URL + `api/income/${id}`);
  }

}
