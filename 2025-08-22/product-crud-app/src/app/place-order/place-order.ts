import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { IProduct } from '../iproduct';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-place-order',
  imports: [CommonModule, FormsModule],
  templateUrl: './place-order.html',
})
export class placeorder implements OnInit {
  products: IProduct[] = [];
  selectedProductId: number | null = null;
  qty: number = 0;
  message: string = '';

  constructor(private service: Product) {}

  ngOnInit(): void {
    this.service.getProducts().subscribe(data => this.products = data);
  }

  placeOrder() {
    if (this.selectedProductId && this.qty > 0) {
      const product = this.products.find(p => p.id === this.selectedProductId);

      if (product && this.qty > product.qty) {
        this.message = "Not enough stock available!";
        return;
      }

      this.service.placeOrder(this.selectedProductId, this.qty)
        .subscribe({
          next: () => this.message = "Order placed successfully!",
          error: () => this.message = "Order failed!"
        });
    }
  }
}
