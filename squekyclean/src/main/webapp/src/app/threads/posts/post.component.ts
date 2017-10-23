import { Component, Input } from '@angular/core';
import { Post } from './post'

@Component({
  selector: 'post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent {
     @Input()
     public post : Post;
}
