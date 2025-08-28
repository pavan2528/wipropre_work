import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { IOrder } from '../iorder';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-order-history',
  imports: [DatePipe],
  templateUrl: './order-history.html',
  styleUrl: './order-history.css'
})

export class OrderHistory implements OnInit {
  orders: IOrder[] = [];

  constructor(private service: Product) {}

  ngOnInit(): void {
    this.service.getOrderHistory()
      .subscribe(data => this.orders = data);
  }
}

