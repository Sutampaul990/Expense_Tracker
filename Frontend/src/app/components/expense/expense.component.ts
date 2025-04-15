import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { ExpenseService } from 'src/app/services/expense/expense.service';

@Component({
  selector: 'app-expense',
  templateUrl: './expense.component.html',
  styleUrls: ['./expense.component.scss']
})
export class ExpenseComponent {

  expenseForm !: FormGroup;
  listOfCategory: any[] = [
    "Education",
    "Groceries",
    "Health",
    "Subscription",
    "Takeaways",
    "Clothing",
    "Travelling",
    "Other"
  ];

  expenses: any;

  constructor(private fb: FormBuilder,
    private expenseService: ExpenseService,
    private message: NzMessageService,
    private router: Router
  ) { }

  ngOnInit() {
    this.getAllExpenses();
    this.expenseForm = this.fb.group({
      title: [null, Validators.required],
      amount: [null, Validators.required],
      date: [null, Validators.required],
      category: [null, Validators.required],
      description: [null, Validators.required],
    })
  }

  submitForm() {
    this.expenseService.postExpense(this.expenseForm.value).subscribe(res => {
      this.message.success("Expense posted successfully", { nzDuration: 5000 })
    }, error => {
      this.message.error("Error while posting expense", { nzDuration: 5000 });
    })
  }

  getAllExpenses() {
    this.expenseService.getAllExpenses().subscribe(res => {
      this.expenses = res;
    }, error => {
      this.message.error("Error fetching expenses!!!", { nzDuration: 5000 });
    })
  }

  updateExpense(id: Number) {
    this.router.navigateByUrl(`/expense/${id}/edit`);
  }

  deleteExpense(id: Number) {
    this.expenseService.deleteExpense(id).subscribe(res => {
      this.message.success("Expense deleted successfully...", { nzDuration: 5000 });
      this.getAllExpenses();
    }, error => {
      this.message.error("Error while deleting expense", { nzDuration: 5000 });
    })
  }

}
