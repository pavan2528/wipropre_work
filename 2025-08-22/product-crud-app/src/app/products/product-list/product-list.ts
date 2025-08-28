import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { IProduct } from '../../iproduct';
import { Product } from '../../product';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-list',
  imports: [CommonModule],
  templateUrl: './product-list.html',
  styleUrl: './product-list.css'
})
export class ProductList implements OnInit{

  products: IProduct[] = [];

  constructor(private service: Product, private router: Router) {}

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts() {
    this.service.getProducts().subscribe({
      next: data => (this.products = data),
      error: err => console.error('Failed to load products', err)
    });
  }

  onAdd() { this.router.navigate(['/products/add']); }
  onEdit(id: number) { this.router.navigate(['/products/edit', id]); }

  onDelete(id: number) {
    if (!confirm('Delete this product?')) return;
    this.service.deleteProduct(id).subscribe(() => this.loadProducts());
  }

}
