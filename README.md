# SuperAdapter
SuperAdapter is an adapter created to avoid reapeating RecyclerView adapter and duplicated code.

## Getting Started

Use SuperAdapter to create no more RecyclerView Adapter. Just implement it using gradle:
```
implementation 'com.github.vinceMuni.SuperAdapter:0.1.0'
```

### Prerequisites

It works with Kotlin and only from Android Kitkat(v19) and above.


### Using

To start you can instantiate your SuperAdapter in your activity like this:

```
val adapter = SuperAdapter.create (
    items,                                                        //Items you want to pass to adapter
    layoutRes,                                                    //Layout to be inflated for each item 
    object: OnViewLoadedListener {                                //Listener to bind an item to respective view
         override fun onViewClicked(itemView: View, any: Any) {
                    //TODO Insert your action on View clicked
                }

                override fun onViewLoaded(itemView: View, any: Any) {
                    //TODO Insert your action on View loaded
                } 
        }
)

recyclerView.layoutManager = LinearLayoutManager(this)
recyclerView.adapter = adapter

```

Simple and easy to implement. You just need to be careful and provide correct view ids 
to manage view binding, directly in your activity.

## Author

* **Vince Muni**

## License

This project is licensed under the Apache 2.0 License - see the [LICENSE.md](LICENSE.md) file for details

## Support
<span class="badge-buymeacoffee"><a href="buymeacoff.ee/eslJYdWTA" title="Donate to this project using Buy Me A Coffee"><img src="https://img.shields.io/badge/buy%20me%20a%20coffee-donate-red.svg" alt="Buy Me A Coffee donate button" /></a></span>

