import { Component, OnInit } from '@angular/core';
import { IProduct } from '../../iproduct';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { Product } from '../../product';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-product-form',
  imports: [CommonModule, RouterModule, FormsModule],
  standalone: true,
  templateUrl: './product-form.html',
  styleUrl: './product-form.css'
})
export class ProductForm implements OnInit{

  product: IProduct = { id: 0, name: '', category: '', price: 0, qty: 0 };
  isEdit = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private service: Product
  ) {}

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id');
    if (idParam) {
      this.isEdit = true;
      const id = Number(idParam);
      this.service.getProductById(id).subscribe({
        next: p => (this.product = p),
        error: err => console.error('Failed to load product', err)
      });
    }
  }

  save() {
    if (this.isEdit) {
      this.service.updateProduct(this.product).subscribe(() => this.router.navigate(['/products']));
    } else {
      const payload = { name: this.product.name, category: this.product.category, price: this.product.price, qty: this.product.qty };
      this.service.addProduct(payload).subscribe(() => this.router.navigate(['/products']));
    }
  }

  cancel() { this.router.navigate(['/products']); }

}
