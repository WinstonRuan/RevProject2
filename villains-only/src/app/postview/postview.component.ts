import { LikepostService } from './../services/likepost.service';
import { Picture } from './../model/picture.model';
import { PictureService } from './../services/picture.service';
import { UserService } from './../services/user.service';
import { User } from './../model/user.model';
import { Message } from './../model/message.model';
import { PostService } from './../services/post.service';
import { Post } from './../model/post.model';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../services/data.service';

@Component({
  selector: 'app-postview',
  templateUrl: './postview.component.html',
  styleUrls: ['./postview.component.css']
})
export class PostviewComponent implements OnInit {

  public message: Message = new Message('');
  private profilePicture: string;
  private posts: Post[];

  private userPost: string;
  private currentUser: User;

  private maxChar = 250;
  private charLeft: number;

  private rawUrlString: string;
  private imageUrl: Picture[];


  constructor(private postService: PostService, private userService: UserService
    , private pictureService: PictureService, private likepostService: LikepostService, private router: Router, private dataService: DataService) { }

  getAllPost(): void {
    this.getUserLikes();
    this.postService.getAllPost().subscribe(
      postsIn => {
        for (let i = 0; i < postsIn.length; i++) {
          for (let p = 0; p < this.currentUser.likes.length; p++) {
            if (postsIn[i].postId === this.currentUser.likes[p].postId) {
              postsIn[i].likedPost = true;
            }
          }
          if (postsIn[i].contentsPic.length !== 0) {
            postsIn[i].showHide = true;
          }
        }
        this.posts = postsIn;
      },
      error => this.message.text = 'something went wrong');
  }

  getUserLikes(): void {
    this.userService.getUserLikes(this.currentUser).subscribe(
      postLike => {
        this.currentUser.likes = postLike;
        console.log(this.currentUser.likes);
      },
      error => this.message.text = 'something went wrong');
  }

  submitPost(): void {

    this.imageUrl = [];
    let tempPicture: Picture = new Picture(undefined, undefined, undefined);
    var post = new Post(undefined, this.userPost, undefined, this.currentUser, undefined, undefined);
    if (this.rawUrlString !== undefined) {
      let rawUrl = this.rawUrlString.split(' ');
      for (let k = 0; k < rawUrl.length; k++) {
        tempPicture = new Picture(undefined, undefined, rawUrl[k]);
        this.imageUrl[k] = tempPicture;
      }
    }
    post.contentsPic = this.imageUrl;
    this.postService.createPost(post).subscribe(
      posts => {
      },
      error => this.message.text = 'Failed to post');

    (<HTMLInputElement>document.getElementById('postSubmit')).value = '';
    (<HTMLInputElement>document.getElementById('imgInput')).value = '';
    this.getAllPost();
    window.location.reload();
  }



  getCharLeft() {
    if (this.userPost != undefined)
      this.charLeft = this.maxChar - this.userPost.length;
  }

  ngOnInit() {
    this.currentUser = this.userService.getLoggedInUser();
    this.getUserLikes();
    this.charLeft = this.maxChar;
    this.getAllPost();
  }

  likePost(post: Post) {
    this.likepostService.likePost(post, this.currentUser);
    post.likedPost = !post.likedPost;
    this.getUserLikes();

  }

  public toSelectedUserPostView(user: User): void {
    this.userService.getUserByEmail(user).subscribe(user => {
      this.dataService.changeMessage(user);
      this.router.navigate(['userhome']);

    },
      error => { console.log('something went wrong'); }
    );
  }

}
