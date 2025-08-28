import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IProduct } from './iproduct';
import { IOrder } from './iorder';

@Injectable({
  providedIn: 'root'
})
export class Product {
  
  private apiUrl = 'http://localhost:8080/api/products';
  private orderUrl = 'http://localhost:8080/api/orders';

  constructor(private http: HttpClient) {}

  getProducts(): Observable<IProduct[]> {
    return this.http.get<IProduct[]>(this.apiUrl);
  }

  placeOrder(productId: number, qty: number): Observable<IOrder> {
    return this.http.post<IOrder>(`${this.orderUrl}/place/${productId}?qty=${qty}`, {});
  }

  getOrderHistory(): Observable<IOrder[]> {
    return this.http.get<IOrder[]>(`${this.orderUrl}/history`);
  }

  getProductById(id: number): Observable<IProduct> {
    return this.http.get<IProduct>(`${this.apiUrl}/${id}`);
  }

  addProduct(product: Omit<IProduct, 'id'>): Observable<IProduct> {
    return this.http.post<IProduct>(this.apiUrl, product);
  }

  updateProduct(product: IProduct): Observable<IProduct> {
    return this.http.put<IProduct>(`${this.apiUrl}/${product.id}`, product);
  }

  deleteProduct(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
