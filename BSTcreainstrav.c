#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
void inOrder();
struct node
{
	int key;
	struct node *left ,*right;
};
struct node *newNode(int item)
{
	struct node * temp = (struct node *) malloc(sizeof(struct node));
	temp->key = item;
	temp->left = NULL;
	temp->right = NULL;

	return temp;
}

void inOrder(struct node *root)
{
	if(root != NULL)
	{
	inOrder(root->left);
	printf("%d", root->key);
	inOrder(root->right);
    }
}
struct node* insert(struct node *node,int key)
{
	if( node == NULL)
	{
		return newNode(key);
	}

	if(key < node->key)
	{
		node->left = insert(node->left,key);
	}
	else if(key > node->key)
	{
         node->right = insert(node->right,key);
	}
	return node;
}
void main()
{
	struct node *root = NULL;
	root = insert(root, 50); 
    insert(root, 30); 
    insert(root, 20); 
    insert(root, 40); 
    insert(root, 70); 
    insert(root, 60); 
    insert(root, 80); 
   
    // print inoder traversal of the BST 
    inOrder(root); 
   

}