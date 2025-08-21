import { Component, OnInit } from '@angular/core';
import { VehicleService } from '../vehicle-service';
import { Vehicle } from '../vehicle';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-vehicle',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './vehicle.html',
  styleUrls: ['./vehicle.css']
})
export class VehicleComponent implements OnInit{

  vehicles: Vehicle[] = [];
  newVehicle: Vehicle = { id: 0, make: '', fuelType: '', model: '', price: 0 };
  editingVehicle: Vehicle | null = null;

  constructor(private vehicleService: VehicleService) { }

  ngOnInit(): void {
    this.loadVehicles();
  }

  loadVehicles() {
    this.vehicleService.getVehicles().subscribe(data => {
      this.vehicles = data;
    });
  }

  addVehicle() {
    this.vehicleService.addVehicle(this.newVehicle).subscribe(() => {
      this.loadVehicles();
      this.newVehicle = { id: 0, make: '', fuelType: '', model: '', price: 0 };
    });
  }

  editVehicle(vehicle: Vehicle) {
    this.editingVehicle = { ...vehicle };
  }

  updateVehicle() {
    if (this.editingVehicle) {
      this.vehicleService.updateVehicle(this.editingVehicle).subscribe(() => {
        this.loadVehicles();
        this.editingVehicle = null;
      });
    }
  }

  deleteVehicle(id: number) {
    this.vehicleService.deleteVehicle(id).subscribe(() => {
      this.loadVehicles();
    });
  }
}
