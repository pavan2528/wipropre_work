import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { Secondcomp } from './app/secondcomp/secondcomp';
import { Login } from './app/login/login';
import { Demo } from './app/demo/demo';

bootstrapApplication(Demo, appConfig)
  .catch((err) => console.error(err));
