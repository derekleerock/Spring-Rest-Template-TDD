package com.example.resttemplatedemo.jsonplaceholderapi

class JSONPlaceholderAPIUserFixture {
    companion object {
        val empty: JSONPlaceholderAPIUser
            get() {
                return JSONPlaceholderAPIUser(
                        id = -1,
                        name = "",
                        username = "",
                        email = "",
                        address = JSONPlaceholderAPIAddress(
                                street = "",
                                suite = "",
                                city = "",
                                zipcode = "",
                                geo = JSONPlaceholderAPIGeo(lat = "", lng = "")
                        ),
                        phone = "",
                        website = "",
                        company = JSONPlaceholderAPICompany(
                                name = "",
                                catchPhrase = "",
                                bs = ""
                        )
                )
            }
    }
}
