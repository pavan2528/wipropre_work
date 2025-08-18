import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { ToggleMessage } from './app/toggle-message/toggle-message';
import { SwitchDemo } from './app/switch-demo/switch-demo';
import { SearchFilter } from './app/search-filter/search-filter';
import { Home } from './app/home/home';


// bootstrapApplication(SwitchDemo, appConfig)
//   .catch((err) => console.error(err));



bootstrapApplication(Home, appConfig)
  .catch((err) => console.error(err));