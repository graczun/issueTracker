import { Routes, RouterModule } from '@angular/router';
import { ProjectComponent } from './project/project.component';
import { LoginComponent } from './login/login.component';

const appRoutes: Routes = [
  { path: '', component: ProjectComponent },
  { path: 'login', component: LoginComponent },
  { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);
